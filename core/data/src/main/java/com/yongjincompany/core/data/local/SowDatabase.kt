package com.yongjincompany.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yongjincompany.core.data.local.dao.ShoesDao
import com.yongjincompany.core.data.local.entity.ShoesEntity

@Database(entities = [ShoesEntity::class], version = 1)
abstract class SowDatabase : RoomDatabase() {
    abstract fun shoesDao(): ShoesDao
}