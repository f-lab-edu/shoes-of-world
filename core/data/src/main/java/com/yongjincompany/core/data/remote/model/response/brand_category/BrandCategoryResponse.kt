package com.yongjincompany.core.data.remote.model.response.brand_category

import kotlinx.serialization.Serializable

@Serializable
data class BrandCategoryResponse(
    val id: Int,
    val imageUrl: String
)
