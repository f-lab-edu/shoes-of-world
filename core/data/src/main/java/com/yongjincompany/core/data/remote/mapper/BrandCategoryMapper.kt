package com.yongjincompany.core.data.remote.mapper

import com.yongjincompany.core.data.local.entity.BrandCategoryEntity
import com.yongjincompany.core.data.remote.model.response.brand_category.BrandCategoryResponse
import com.yongjincompany.core.domain.entity.BrandCategory

internal fun BrandCategoryResponse.responseToEntity(): BrandCategory =
    BrandCategory(
        id,
        imageUrl,
    )

internal fun BrandCategoryEntity.localEntityToDomainEntity(): BrandCategory =
    BrandCategory(
        id,
        imageUrl,
    )

internal fun BrandCategoryResponse.responseToLocalEntity(): BrandCategoryEntity =
    BrandCategoryEntity(
        id,
        imageUrl,
    )