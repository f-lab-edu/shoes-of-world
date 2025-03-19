package com.yongjincompany.core.data.remote.mapper

import com.yongjincompany.core.data.local.entity.BannerEntity
import com.yongjincompany.core.data.remote.model.response.banner.BannerResponse
import com.yongjincompany.core.domain.entity.Banner

internal fun BannerResponse.responseToEntity(): Banner =
    Banner(
        id,
        imageUrl
    )

internal fun BannerEntity.localEntityToDomainEntity(): Banner =
    Banner(
        id,
        imageUrl,
    )

internal fun BannerResponse.responseToLocalEntity(): BannerEntity =
    BannerEntity(
        id,
        imageUrl,
    )