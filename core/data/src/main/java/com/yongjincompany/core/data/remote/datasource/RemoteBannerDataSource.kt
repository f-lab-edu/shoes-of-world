package com.yongjincompany.core.data.remote.datasource

import com.yongjincompany.core.data.remote.model.response.banner.BannerResponse

interface RemoteBannerDataSource {
    suspend fun fetchBannerList(): List<BannerResponse>
}