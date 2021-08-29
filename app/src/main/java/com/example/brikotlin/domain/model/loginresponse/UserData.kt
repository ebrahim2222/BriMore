package com.example.brikotlin.domain.model.loginresponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserData(

    @SerializedName("id")
    @Expose
    val id:Int,
    @SerializedName("name")
    @Expose
    val name:String ,
    @SerializedName("api_token")
    @Expose
    val apiToken:String,
    @SerializedName("image")
    @Expose
    val image:String,
    @SerializedName("code")
    @Expose
    val code:String,
    @SerializedName("first_login")
    @Expose
    val firstLogin:String

)
