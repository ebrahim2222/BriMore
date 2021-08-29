package com.example.brikotlin.domain.model.main.brands

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BrandsDetails(
    @SerializedName("id")
    @Expose
    val id:Int,
    @SerializedName("name")
    @Expose
    val name:String,
    @SerializedName("logo")
    @Expose
    val logo:String
)
