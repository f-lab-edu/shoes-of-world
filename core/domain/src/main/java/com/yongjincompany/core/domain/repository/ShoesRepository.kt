package com.yongjincompany.core.domain.repository

import com.yongjincompany.core.domain.entity.Shoes
import kotlinx.coroutines.flow.Flow

interface ShoesRepository {
    suspend fun fetchAllShoesList(): Flow<List<Shoes>>
}