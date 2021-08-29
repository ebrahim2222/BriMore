package com.example.brikotlin.domain.model.main.dynamicsectionone

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DynamicSectionAttributeValues(
    @SerializedName("id") @Expose
     var id: Int,
    @SerializedName("name")
@Expose
    var name: String,

@SerializedName("color_code")
@Expose
    var colorCode: String,
)
