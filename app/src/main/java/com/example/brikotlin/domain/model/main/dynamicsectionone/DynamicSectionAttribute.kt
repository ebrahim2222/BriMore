package com.example.brikotlin.domain.model.main.dynamicsectionone

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DynamicSectionAttribute(
    @SerializedName("id") @Expose
    private var id: Int,
    @SerializedName("name")
@Expose
    var name: String,

@SerializedName("values")
@Expose
    var values: List<DynamicSectionAttributeValues>
)