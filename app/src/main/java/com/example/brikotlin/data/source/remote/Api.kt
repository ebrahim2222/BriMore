package com.example.brikotlin.data.source.remote

import com.example.brikotlin.domain.model.category.Categories
import com.example.brikotlin.domain.model.loginresponse.LoginResponse
import com.example.brikotlin.domain.model.main.HomePage
import com.example.brikotlin.domain.model.paging.PassengerResponse
import com.example.brikotlin.domain.model.products.Products
import retrofit2.http.*

interface Api {

    @FormUrlEncoded
    @POST("api/eve/login")
    suspend fun loginApi(@Field("loginKey") email:String , @Field("password") pass:String):LoginResponse

    @GET("api/eve/home")
    suspend fun homeApi(@Header("Authorization") header:String):HomePage

    @GET("api/eve/categories")
    suspend fun categoriesApi(@Header("Authorization") header:String):Categories

    @GET("api/eve/category/{id}")
    suspend fun subCategoriesApi(@Header("Authorization") header:String , @Path("id") id:Int):Categories

    @GET("api/eve/subcategory/{id}/products")
    suspend fun productsApi(@Header("Authorization")header: String,@Path("id") id:Int):Products

    @GET("passenger")
    suspend fun pagingApi(@Query("page") page:Int, @Query("size") size:Int):PassengerResponse

}