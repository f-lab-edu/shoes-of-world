package com.yongjincompany.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "banner")
data class BannerEntity(
    @PrimaryKey val id: Int,
    val imageUrl: String,
)
