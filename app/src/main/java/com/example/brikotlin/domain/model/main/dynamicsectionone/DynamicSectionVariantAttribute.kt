package com.example.brikotlin.domain.model.main.dynamicsectionone

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DynamicSectionVariantAttribute(
    @SerializedName("id") @Expose
    var id: Int,
    @SerializedName("name")
@Expose
    var name: String,

    @SerializedName("value_id")
@Expose
    var valueId: Int,

    @SerializedName("value_name")
@Expose
    var valueName: String,

    @SerializedName("color_code")
@Expose
    var colorCode: String,
)
