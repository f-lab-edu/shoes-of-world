package com.yongjincompany.core.data.local.datasource

import com.yongjincompany.core.data.local.entity.BrandCategoryEntity

interface LocalBrandCategoryDataSource {
    suspend fun selectAllFromBrandCategoryTable(): List<BrandCategoryEntity>
    suspend fun insertBrandCategory(brandCategory: List<BrandCategoryEntity>)
}