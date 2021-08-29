package com.example.brikotlin.ui.paging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.brikotlin.domain.usecase.PagingUseCase
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class PagingViewModelFactory @Inject constructor(
    val pagingUseCase: PagingUseCase
    ) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PagingViewModel(pagingUseCase) as T
    }
}