package com.yongjincompany.core.data.remote.mapper

import com.yongjincompany.core.data.local.entity.ShoesEntity
import com.yongjincompany.core.data.remote.model.response.ShoesResponse
import com.yongjincompany.core.domain.entity.Shoes

internal fun ShoesResponse.responseToEntity(): Shoes =
    Shoes(
        id,
        name,
        brandName,
        imageUrl,
        bookmarkCount
    )

internal fun ShoesEntity.localEntityToDomainEntity(): Shoes =
    Shoes(
        id,
        name,
        brandName,
        imageUrl,
        bookmarkCount
    )

internal fun ShoesResponse.responseToLocalEntity(): ShoesEntity =
    ShoesEntity(
        id,
        name,
        brandName,
        imageUrl,
        bookmarkCount
    )