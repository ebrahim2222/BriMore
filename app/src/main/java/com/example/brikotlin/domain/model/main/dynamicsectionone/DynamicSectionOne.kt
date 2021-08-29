package com.example.brikotlin.domain.model.main.dynamicsectionone

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DynamicSectionOne(
    @SerializedName("id") @Expose
     var id: Int,
    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("type")
    @Expose
     var type: Int,

    @SerializedName("background_color")
    @Expose
     var backgroundColor: Any,

    @SerializedName("order")
    @Expose
     var order: Any,

    @SerializedName("section_type")
    @Expose
     var sectionType: String,

    @SerializedName("data")
    @Expose
     var data: DynamicSectionData
)
