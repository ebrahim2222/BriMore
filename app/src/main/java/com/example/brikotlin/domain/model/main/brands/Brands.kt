package com.example.brikotlin.domain.model.main.brands

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Brands(
    @SerializedName("id")
    @Expose
    val id:Int,
    @SerializedName("name")
    @Expose
    val name:String,
    @SerializedName("type")
    @Expose
    val type:Int,
    @SerializedName("background_color")
    @Expose
    val backgroundColor: Any,
    @SerializedName("order")
    @Expose
    val order: Any,
    @SerializedName("section_type")
    @Expose
    val sectionType:String,
    @SerializedName("data")
    @Expose
    val brandsData:BrandsData
    )
