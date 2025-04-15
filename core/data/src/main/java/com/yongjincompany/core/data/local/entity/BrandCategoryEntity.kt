package com.yongjincompany.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "brandcategory")
data class BrandCategoryEntity(
    @PrimaryKey val id: Int,
    val imageUrl: String,
)