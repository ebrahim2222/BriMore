package com.example.brikotlin.domain.model.loginresponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("data")
    @Expose
    val data:UserData
)
