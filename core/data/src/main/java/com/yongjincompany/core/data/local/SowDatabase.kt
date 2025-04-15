package com.yongjincompany.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yongjincompany.core.data.local.dao.BannerDao
import com.yongjincompany.core.data.local.dao.BrandCategoryDao
import com.yongjincompany.core.data.local.dao.ShoesDao
import com.yongjincompany.core.data.local.entity.BannerEntity
import com.yongjincompany.core.data.local.entity.BrandCategoryEntity
import com.yongjincompany.core.data.local.entity.ShoesEntity

@Database(
    entities = [ShoesEntity::class, BannerEntity::class, BrandCategoryEntity::class],
    version = 1
)
abstract class SowDatabase : RoomDatabase() {
    abstract fun shoesDao(): ShoesDao
    abstract fun bannerDao(): BannerDao
    abstract fun brandCategoryDao(): BrandCategoryDao
}