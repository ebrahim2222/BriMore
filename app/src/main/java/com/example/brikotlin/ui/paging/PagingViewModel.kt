package com.example.brikotlin.ui.paging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.brikotlin.domain.usecase.PagingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PagingViewModel @Inject constructor(
    val pagingUseCase: PagingUseCase
    ) : ViewModel() {

        val response = Pager( PagingConfig(
            pageSize = 10,
            maxSize = 100,
            enablePlaceholders = false
        ) ){
            PagingDataSource(pagingUseCase)
        }.flow.cachedIn(viewModelScope)

}