package com.example.brikotlin.domain.usecase

import com.example.brikotlin.data.repository.RepositoryImp
import com.example.brikotlin.domain.model.paging.PassengerResponse
import javax.inject.Inject

class PagingUseCase @Inject constructor(
    val repositoryImp: RepositoryImp
    ) {

    suspend fun getPagingApi(page:Int,size:Int):PassengerResponse{
        return repositoryImp.getPagingApi(page,size)
    }

}