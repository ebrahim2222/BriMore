package com.example.brikotlin.domain.model.category

import com.example.brikotlin.domain.model.main.maincategory.MainCategoryDetails
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Categories (
    @SerializedName("data")
    @Expose
    var data: List<MainCategoryDetails>
)