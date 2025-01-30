package com.yongjincompany.core.domain.repository

import com.yongjincompany.core.model.Shoes

interface ShoesRepository {
    suspend fun fetchAllShoesList(): List<Shoes>
}