package com.example.brikotlin.domain.model.main.dynamicsectionone

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DynamicSectionData(
    @SerializedName("data") @Expose
     var data: List<DynamicSectionDetails>
)
