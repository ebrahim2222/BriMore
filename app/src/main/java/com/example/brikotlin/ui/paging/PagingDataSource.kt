package com.example.brikotlin.ui.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.brikotlin.domain.model.paging.Passenger
import com.example.brikotlin.domain.usecase.PagingUseCase
import javax.inject.Inject

class PagingDataSource @Inject constructor(
    val pagingUseCase: PagingUseCase
    ) : PagingSource<Int,Passenger>() {
    val pagingStartIndex = 0
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Passenger> {

        return try {
            val position = params.key ?: pagingStartIndex
            val size = params.loadSize
            val response = pagingUseCase.getPagingApi(position,size)
            LoadResult.Page(
                data = response.data,
                prevKey = if(position > 0) position - 1 else null,
                nextKey = if(position < response.totalPages) position + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, Passenger>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}