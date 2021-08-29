package com.example.brikotlin.ui.products

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
import com.example.brikotlin.R
import com.example.brikotlin.databinding.FragmentProductsBinding
import com.example.brikotlin.domain.model.main.dynamicsectionone.DynamicSectionVariant
import com.example.brikotlin.domain.model.main.maincategory.MainCategoryDetails
import com.example.brikotlin.domain.usecase.UserUseCase
import com.example.brikotlin.utils.ResponseError
import com.example.brikotlin.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@AndroidEntryPoint
class ProductsFragment : Fragment() {

    @Inject lateinit var userUseCase: UserUseCase
    val productsViewModel:ProductsViewModel by viewModels()
    @Inject lateinit var productsAdapter: ProductsAdapter
    lateinit var binding:FragmentProductsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProductsBinding.inflate(inflater)
        val view = binding.root


        setUpRecycler()

        val data = arguments?.getParcelable<MainCategoryDetails>("subCatId")

        lifecycleScope.launchWhenStarted {
            val token = productsViewModel.getUserToken()
            token.asLiveData().observe(requireActivity(), Observer {
               productsViewModel.productsApi(it!!,data!!.id)
            })

            productsViewModel.mutableStateFlow.collect {
                when(it.status)
                {
                    Status.SUCCESS ->{
                        val data1 = it.data!!.data
                        for(variants in data1!!){
                            productsAdapter.setProductsData(requireContext(),variants!!.variants)
                        }
                        productsAdapter.notifyDataSetChanged()
                        binding.productsProgresBar.visibility = View.INVISIBLE

                    }
                    Status.ERROR -> {
                        ResponseError.errorCode(requireContext(),it.code!!)
                        binding.productsProgresBar.visibility = View.INVISIBLE

                    }
                }
            }



        }



        return view
    }

    private fun setUpRecycler() {
        binding.productRv.adapter = productsAdapter
        productsAdapter.dataList = null
    }

}