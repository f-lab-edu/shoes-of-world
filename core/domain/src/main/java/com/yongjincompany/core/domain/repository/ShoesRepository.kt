package com.yongjincompany.core.domain.repository

import com.yongjincompany.core.domain.entity.ShoesEntity

interface ShoesRepository {
    suspend fun fetchAllShoesList(): List<ShoesEntity>
}