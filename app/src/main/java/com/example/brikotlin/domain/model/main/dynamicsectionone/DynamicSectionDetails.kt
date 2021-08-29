package com.example.brikotlin.domain.model.main.dynamicsectionone

import androidx.room.Embedded
import com.example.brikotlin.domain.model.main.brands.BrandsDetails
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DynamicSectionDetails(
    @SerializedName("id")
    @Expose
    var id: Int,
    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("brief")
    @Expose
    var brief: String,

    @SerializedName("image")
    @Expose
    var image: String,

    @SerializedName("brand")
    @Expose
    var brand: BrandsDetails,

    @SerializedName("hot_deal")
    @Expose
    private var hotDeal: Any,

    @SerializedName("attributes")
    @Expose
     var attributes: List<DynamicSectionAttribute>,

    @SerializedName("variants")
    @Expose
    @Embedded var variants: List<DynamicSectionVariant>,

    @SerializedName("tag_list")
    @Expose
     var tagList: List<Any>
)
