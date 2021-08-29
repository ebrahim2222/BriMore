package com.example.brikotlin.domain.model.products

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.brikotlin.domain.model.main.dynamicsectionone.DynamicSectionDetails
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
data class Products(
    @SerializedName("data")
    @Expose
    var data: List<DynamicSectionDetails?>? = null
)
