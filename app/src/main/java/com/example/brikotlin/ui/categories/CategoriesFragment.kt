package com.example.brikotlin.ui.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import com.example.brikotlin.R
import com.example.brikotlin.databinding.FragmentCategoriesBinding
import com.example.brikotlin.domain.model.main.maincategory.MainCategoryDetails
import com.example.brikotlin.domain.usecase.UserUseCase
import com.example.brikotlin.ui.main.MainFragment
import com.example.brikotlin.utils.ResponseError
import com.example.brikotlin.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@AndroidEntryPoint
class CategoriesFragment : Fragment() {
    lateinit var binding:FragmentCategoriesBinding
    var categoryList:ArrayList<MainCategoryDetails>?=null
    val categoryViewModel:CategoryViewModel by viewModels()
    @Inject lateinit var categoryAdapter: CategoryAdapter
    @Inject lateinit var userUseCase: UserUseCase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCategoriesBinding.inflate(inflater)
        val view = binding.root
        setUpRecycler()
        binding.categoryProgresBar.visibility = View.GONE


        lifecycleScope.launchWhenStarted {
            val token = categoryViewModel.getUserToken()
            token.asLiveData().observe(requireActivity(), Observer {
                categoryViewModel.categoriesApi(it!!)
            })
            categoryViewModel.mutableStateFlow.collect {

                when(it.status){
                    Status.SUCCESS -> {
                        val categoryData = it.data!!.data
                        categoryAdapter.setCategoryData(requireContext(),categoryData)
                        categoryAdapter.notifyDataSetChanged()
                    }
                    Status.ERROR -> {
                        ResponseError.errorCode(requireContext(),it.code!!)
                    }
                }

            }

        }

        return view
    }

    private fun setUpRecycler() {
        binding.categoryRv.adapter = categoryAdapter
    }


}