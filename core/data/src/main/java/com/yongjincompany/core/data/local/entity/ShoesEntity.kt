package com.yongjincompany.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shoes")
data class ShoesEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val brandName: String,
    val imageUrl: String,
    val bookmarkCount: Int
)
