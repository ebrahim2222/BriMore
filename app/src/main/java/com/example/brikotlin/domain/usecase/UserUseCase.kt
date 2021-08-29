package com.example.brikotlin.domain.usecase

import com.example.brikotlin.data.repository.RepositoryImp
import com.example.brikotlin.domain.model.loginresponse.UserData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserUseCase @Inject constructor(val repositoryImp: RepositoryImp) {

    suspend fun saveToken(token:String){
        repositoryImp.saveUserToken(token)

    }


    suspend fun saveEmail(email:String){
        repositoryImp.saveUSerEmail(email)
    }
    suspend fun savePassword(password:String){
        repositoryImp.saveUserPassword(password)
    }

    suspend fun getEmail():String?{
        return repositoryImp.getUserEmail()
    }
    suspend fun getPassword():String?{
        return repositoryImp.getUserPassword()
    }



    suspend fun getToken(): Flow<String?>{
        return repositoryImp.getUserToken()
    }

    suspend fun saveUser(user:UserData){
        repositoryImp.saveUser(user)
    }

    suspend fun getUser():Flow<String?>{
        return repositoryImp.getUserData()
    }

}