package com.example.brikotlin.domain.model.main.maincategory

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MainCategoryData(
    @SerializedName("data") @Expose
    var data: List<MainCategoryDetails>
)
