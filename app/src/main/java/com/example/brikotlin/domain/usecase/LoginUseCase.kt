package com.example.brikotlin.domain.usecase

import com.example.brikotlin.data.repository.RepositoryImp
import com.example.brikotlin.domain.model.loginresponse.LoginResponse
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    val repositoryImp: RepositoryImp
)  {

    suspend fun loginApi(email:String ,pass:String):LoginResponse{
        return repositoryImp.loginApi(email,pass)
    }

}