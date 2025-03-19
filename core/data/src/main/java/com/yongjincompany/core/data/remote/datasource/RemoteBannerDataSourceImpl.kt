package com.yongjincompany.core.data.remote.datasource

import com.yongjincompany.core.data.remote.api.BannerApi
import com.yongjincompany.core.data.remote.model.response.banner.BannerResponse
import jakarta.inject.Inject

class RemoteBannerDataSourceImpl @Inject constructor(
    private val bannerApi: BannerApi
) : RemoteBannerDataSource {
    override suspend fun fetchBannerList(): List<BannerResponse> {
        return bannerApi.fetchBannerList()
    }
}