package com.yongjincompany.core.data.remote.mapper

import com.yongjincompany.core.data.remote.model.response.ShoesResponse
import com.yongjincompany.core.model.Shoes

internal fun ShoesResponse.responseToEntity(): Shoes =
    Shoes(
        id,
        name,
        brandName,
        imageUrl,
        bookmarkCount
    )