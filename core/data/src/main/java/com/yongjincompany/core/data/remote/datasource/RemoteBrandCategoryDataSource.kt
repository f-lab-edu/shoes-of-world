package com.yongjincompany.core.data.remote.datasource

import com.yongjincompany.core.data.remote.model.response.brand_category.BrandCategoryResponse

interface RemoteBrandCategoryDataSource {
    suspend fun fetchBrandCategoryList(): List<BrandCategoryResponse>
}