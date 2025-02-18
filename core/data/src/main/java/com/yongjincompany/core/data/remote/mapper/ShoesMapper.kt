package com.yongjincompany.core.data.remote.mapper

import com.yongjincompany.core.data.remote.model.response.ShoesResponse
import com.yongjincompany.core.domain.entity.ShoesEntity

internal fun ShoesResponse.responseToEntity(): ShoesEntity =
    ShoesEntity(
        id,
        name,
        brandName,
        imageUrl,
        bookmarkCount
    )