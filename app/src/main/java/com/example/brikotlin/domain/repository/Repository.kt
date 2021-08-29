package com.example.brikotlin.domain.repository

import com.example.brikotlin.domain.model.category.Categories
import com.example.brikotlin.domain.model.loginresponse.LoginResponse
import com.example.brikotlin.domain.model.loginresponse.UserData
import com.example.brikotlin.domain.model.main.HomePage
import com.example.brikotlin.domain.model.paging.PassengerResponse
import com.example.brikotlin.domain.model.products.Products
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun loginApi(email:String ,pass:String):LoginResponse

    suspend fun homeApi(header:String):HomePage

    suspend fun categoriesApi(header:String):Categories

    suspend fun subCategoryApi(header:String,id:Int):Categories

    suspend fun ProductsApi(header:String,id:Int):Products

    suspend fun saveUserToken(token:String)

    suspend fun getUserToken():Flow<String?>

    suspend fun saveUSerEmail(email:String)

    suspend fun getUserEmail():String?

    suspend fun saveUserPassword(password:String)

    suspend fun getUserPassword():String?

    suspend fun saveUser(userData: UserData)

    suspend fun getUserData(): Flow<String?>

    suspend fun getPagingApi(page:Int,size:Int): PassengerResponse



}