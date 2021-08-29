package com.example.brikotlin.ui.subcategory

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
import com.example.brikotlin.databinding.FragmentSubCategoryBinding
import com.example.brikotlin.domain.model.main.maincategory.MainCategoryDetails
import com.example.brikotlin.domain.usecase.UserUseCase
import com.example.brikotlin.utils.ResponseError
import com.example.brikotlin.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@AndroidEntryPoint
class SubCategoryFragment : Fragment() {

    val subCategoryViewModel:SubCategoryViewModel by viewModels()
    var subCategoryList:ArrayList<MainCategoryDetails>?=null
    lateinit var binding:FragmentSubCategoryBinding
    @Inject lateinit var subCategoryAdapter:SubCategoryAdapter
    @Inject lateinit var userUseCase: UserUseCase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSubCategoryBinding.inflate(inflater)
        val view = binding.root
        setUpRcycler()
        val data = arguments?.getParcelable<MainCategoryDetails>("categoryID")
        binding.fragmentSubTxt1.text = data!!.name
        lifecycleScope.launchWhenStarted {
            val token = subCategoryViewModel.getUserToken()
            token.asLiveData().observe(requireActivity(), Observer {
                subCategoryViewModel.getSubCategoryApi(it!!,data!!.id)
            })
            subCategoryViewModel.mutableStateFlow.collect {
                when(it.status){
                    Status.SUCCESS -> {
                        val data1 = it.data!!.data
                        subCategoryAdapter.setSubCatData(requireContext(),data1)
                        subCategoryAdapter.notifyDataSetChanged()
                    }
                    Status.ERROR -> {
                        ResponseError.errorCode(requireContext(),it.code!!)
                    }
                }
            }
        }
        return view
    }

    private fun setUpRcycler() {
        binding.subcategoryRv.adapter = subCategoryAdapter
        subCategoryAdapter.dataList = null
    }
}