package com.yongjincompany.core.data.local.datasource

import com.yongjincompany.core.data.local.dao.BannerDao
import com.yongjincompany.core.data.local.entity.BannerEntity
import jakarta.inject.Inject

class LocalBannerDataSourceImpl @Inject constructor(
    private val bannerDao: BannerDao
): LocalBannerDataSource {
    override suspend fun selectAllFromBannerTable(): List<BannerEntity> =
        bannerDao.selectAllFromBannerTable()

    override suspend fun insertBanner(banner: List<BannerEntity>) =
        bannerDao.insertBanner(banner)
}