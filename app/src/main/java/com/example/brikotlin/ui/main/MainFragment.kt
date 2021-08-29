package com.example.brikotlin.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.brikotlin.R
import com.example.brikotlin.databinding.FragmentMainBinding
import com.example.brikotlin.domain.model.main.HomePage
import com.example.brikotlin.domain.model.main.brands.BrandsDetails
import com.example.brikotlin.domain.model.main.dynamicsectionone.DynamicSectionDetails
import com.example.brikotlin.domain.model.main.dynamicsectionone.DynamicSectionVariant
import com.example.brikotlin.domain.model.main.maincategory.MainCategoryDetails
import com.example.brikotlin.utils.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {
    lateinit var navController:NavController
    private  val TAG = "MainFragment"
    lateinit var binding:FragmentMainBinding
    val mainViewModel:MainViewModel by viewModels()
    var homeCatList = ArrayList<MainCategoryDetails>()
    var homeBrandsList = ArrayList<BrandsDetails>()
    var mainProductsList = ArrayList<DynamicSectionVariant>()
    val itemDecoration:SpaceBetweenItem = SpaceBetweenItem(0,20, 0, 0)
    @Inject lateinit var adapter: MainCategoryAdapter
    @Inject lateinit var brandsAdapter: MainBrandsAdapter
    @Inject lateinit var productsAdapter: MainProductsAdapter

    lateinit var data:Resource<HomePage>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater)
        // Inflate the layout for this fragment
        setUpAllRecycler()


        binding.fragmentMainSeeAll.setOnClickListener {
            navController.navigate(R.id.categoriesFragment)
        }

        runBlocking {
            val token = mainViewModel.getToken()
            token.asLiveData().observe(requireActivity(), Observer {
                mainViewModel.homeApi(it!!)
            })
        }
        lifecycleScope.launchWhenStarted {
            mainViewModel.mutableStateFlow.collect {
               data = it
                getHomeData(it)
            }
        }

        binding.mainSwipeLayout.setOnRefreshListener {
            binding.mainSwipeLayout.isRefreshing = true
            getHomeData(data)
        }

        val view = binding.root



        return view
    }


    private fun getHomeData(it: Resource<HomePage>) {
        when(it.status){
            Status.SUCCESS -> {
                val homeCat = it.data!!.mainCategory.data.data
                val homeBrands = it.data.brands.brandsData.data
                val mainProductsList = it.data.dynamicSectionOne.data.data
                setHomeCatToRecycler(homeCat)
                setHomeBrandsToRecycler(homeBrands)
                setHomeProductsToRecycler(mainProductsList)
                binding.mainSwipeLayout.isRefreshing = false

            }
            Status.ERROR -> {
                ResponseError.errorCode(requireContext(),it.code!!)
            }
        }
    }

    private fun setHomeCatToRecycler(homeCat: List<MainCategoryDetails>) {
        for (e in homeCat)
        {
            homeCatList.add(e)
            adapter.setData(requireContext(),homeCatList)
        }
        adapter.notifyDataSetChanged()
    }

    private fun setHomeProductsToRecycler(mainProducts: List<DynamicSectionDetails>) {
        for(e in mainProducts){
            val variant = e.variants

            for(va in variant){
                mainProductsList.add(va)
                productsAdapter.setMainProductData(requireContext(),mainProductsList)
            }

        }
        productsAdapter.notifyDataSetChanged()
    }

    private fun setUpAllRecycler() {
        binding.mainCatRv.adapter = adapter
        binding.mainCatRv.addItemDecoration(itemDecoration)
        binding.mainBrandsRv.adapter = brandsAdapter
        binding.mainProductRv.adapter = productsAdapter

    }

    fun setHomeBrandsToRecycler(homeBrands: List<BrandsDetails>) {
        for(e in homeBrands){
            homeBrandsList.add(e)
            brandsAdapter.setBrandsData(requireContext(),homeBrandsList)
        }
        brandsAdapter.notifyDataSetChanged()
    }


}