package com.example.brikotlin.domain.model.category

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Child(
    @SerializedName("id") @Expose
    var id: Int,
    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("image")
    @Expose
    var image: String,

    @SerializedName("colorCode")
    @Expose
    var colorCode: String,

    @SerializedName("order")
    @Expose
    var order: Int,

    @SerializedName("children")
    @Expose
    var children: List<Any>
)
