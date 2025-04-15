package com.yongjincompany.core.domain.repository

import com.yongjincompany.core.domain.entity.BrandCategory
import kotlinx.coroutines.flow.Flow

interface BrandCategoryRepository {
    fun fetchBrandCategoryList(): Flow<List<BrandCategory>>
}