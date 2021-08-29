package com.example.brikotlin.utils

import androidx.room.TypeConverter
import com.example.brikotlin.domain.model.main.dynamicsectionone.DynamicSectionVariant
import com.example.brikotlin.domain.model.main.dynamicsectionone.DynamicSectionVariantAttribute
import com.example.brikotlin.domain.model.products.Products
import com.google.gson.Gson

class Converter {
    val gson = Gson()
    @TypeConverter
    fun toGson(products: DynamicSectionVariantAttribute):String{
        return gson.toJson(products)
    }
    @TypeConverter
    fun fromGson(s:String):DynamicSectionVariantAttribute{
        return gson.fromJson(s,DynamicSectionVariantAttribute::class.java)
    }
}