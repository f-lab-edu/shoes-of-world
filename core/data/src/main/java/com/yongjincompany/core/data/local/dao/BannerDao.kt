package com.yongjincompany.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yongjincompany.core.data.local.entity.BannerEntity

@Dao
interface BannerDao {
    @Query("SELECT * FROM banner")
    suspend fun selectAllFromBannerTable(): List<BannerEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBanner(banner: List<BannerEntity>)
}