package com.yongjincompany.core.data.local.datasource

import com.yongjincompany.core.data.local.entity.ShoesEntity

interface LocalShoesDataSource {
    suspend fun selectAllFromShoesTable(): List<ShoesEntity>
    suspend fun insertShoes(shoes: List<ShoesEntity>)
}