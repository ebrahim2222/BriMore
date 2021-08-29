package com.example.brikotlin.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.brikotlin.domain.model.main.dynamicsectionone.DynamicSectionVariant
import com.example.brikotlin.domain.model.main.maincategory.MainCategoryDetails
import com.example.brikotlin.domain.model.products.Products
import com.example.brikotlin.utils.Converter

abstract class DataBase : RoomDatabase() {

    abstract fun getDao():Dao
}