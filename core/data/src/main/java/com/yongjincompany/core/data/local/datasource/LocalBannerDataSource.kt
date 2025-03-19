package com.yongjincompany.core.data.local.datasource

import com.yongjincompany.core.data.local.entity.BannerEntity

interface LocalBannerDataSource {
    suspend fun selectAllFromBannerTable(): List<BannerEntity>
    suspend fun insertBanner(banner: List<BannerEntity>)
}