package com.yongjincompany.core.data.remote.datasource

import com.yongjincompany.core.data.remote.api.BrandCategoryApi
import com.yongjincompany.core.data.remote.model.response.brand_category.BrandCategoryResponse
import javax.inject.Inject

class RemoteBrandCategoryDataSourceImpl @Inject constructor(
    private val brandCategoryApi: BrandCategoryApi
) : RemoteBrandCategoryDataSource {
    override suspend fun fetchBrandCategoryList(): List<BrandCategoryResponse> {
        return brandCategoryApi.fetchBrandCategoryList()
    }
}