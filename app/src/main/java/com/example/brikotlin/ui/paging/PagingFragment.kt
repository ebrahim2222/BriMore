package com.example.brikotlin.ui.paging

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.brikotlin.R
import com.example.brikotlin.databinding.FragmentPagingBinding
import com.example.brikotlin.domain.usecase.PagingUseCase
import com.example.brikotlin.utils.Constants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class PagingFragment : Fragment() {
    val pagingViewModel:PagingViewModel by viewModels()
    @Inject lateinit var pagingUseCase:PagingUseCase
    @Inject lateinit var pagingAdapter: PagingAdapter
    lateinit var binding:FragmentPagingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentPagingBinding.inflate(inflater)
        val view = binding.root
        Constants.BASE_URL = "https://api.instantwebtools.net/v1/"
        setUpPaging()
        val factory = PagingViewModelFactory(pagingUseCase)
        lifecycleScope.launchWhenStarted {
            pagingViewModel.response.collectLatest {
                pagingAdapter.submitData(it)
            }
        }
        return view
    }

    private fun setUpPaging() {
        binding.pagingRv.adapter = pagingAdapter
    }


}