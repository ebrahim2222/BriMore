package com.example.brikotlin.domain.model.main.brands

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BrandsData(
    @SerializedName("data")
    @Expose
    val data : List<BrandsDetails>
)
