package com.yongjincompany.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yongjincompany.core.data.local.entity.BrandCategoryEntity

@Dao
interface BrandCategoryDao {
    @Query("SELECT * FROM brandcategory")
    suspend fun selectAllFromBrandCategoryTable(): List<BrandCategoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBrandCategory(brandCategory: List<BrandCategoryEntity>)
}