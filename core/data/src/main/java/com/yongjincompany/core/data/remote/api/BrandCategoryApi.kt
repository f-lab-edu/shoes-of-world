package com.yongjincompany.core.data.remote.api

import com.yongjincompany.core.data.remote.model.response.brand_category.BrandCategoryResponse
import retrofit2.http.GET

interface BrandCategoryApi {
    @GET("brand-category/list")
    suspend fun fetchBrandCategoryList(): List<BrandCategoryResponse>
}