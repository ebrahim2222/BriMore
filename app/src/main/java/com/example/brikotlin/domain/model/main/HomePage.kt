package com.example.brikotlin.domain.model.main

import com.example.brikotlin.domain.model.main.brands.Brands
import com.example.brikotlin.domain.model.main.dynamicsectionone.DynamicSectionOne
import com.example.brikotlin.domain.model.main.maincategory.MainCategory
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HomePage(
    @SerializedName("BRANDS")
    @Expose
    val brands: Brands,
    @SerializedName("CATEGORY")
    @Expose
    val mainCategory: MainCategory,

    @SerializedName("DYNAMIC_SECTION_ONE")
    @Expose
    var dynamicSectionOne: DynamicSectionOne

    )