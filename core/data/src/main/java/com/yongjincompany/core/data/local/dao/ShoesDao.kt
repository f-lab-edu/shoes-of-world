package com.yongjincompany.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yongjincompany.core.data.local.entity.ShoesEntity

@Dao
interface ShoesDao {
    @Query("SELECT * FROM shoes")
    suspend fun selectAllFromShoesTable(): List<ShoesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoes(shoes: List<ShoesEntity>)
}