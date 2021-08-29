
package com.example.brikotlin.data.source.local.room

import androidx.room.*
import androidx.room.Dao
import com.example.brikotlin.domain.model.main.dynamicsectionone.DynamicSectionVariant
import com.example.brikotlin.domain.model.main.maincategory.MainCategoryDetails
import com.example.brikotlin.domain.model.products.Products
import kotlinx.coroutines.flow.Flow
@Dao
interface Dao {
    /*
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMainCategory(cat:DynamicSectionVariant)

    @Query( "SELECT * FROM product")
    fun getMainCategory():Flow<DynamicSectionVariant>

    @Query("DELETE FROM product")
    suspend fun deleteMainCategory()

     */

}