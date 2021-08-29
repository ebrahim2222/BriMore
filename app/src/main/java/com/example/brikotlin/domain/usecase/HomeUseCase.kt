package com.example.brikotlin.domain.usecase

import com.example.brikotlin.data.repository.RepositoryImp
import com.example.brikotlin.domain.model.main.HomePage
import javax.inject.Inject

class HomeUseCase @Inject constructor(val repositoryImp: RepositoryImp) {

    suspend fun homeApi(header:String):HomePage{
        return repositoryImp.homeApi(header)
    }
}