package com.yongjincompany.core.data.remote.api

import com.yongjincompany.core.data.remote.model.response.banner.BannerResponse
import retrofit2.http.GET

interface BannerApi {
    @GET("banners/list")
    suspend fun fetchBannerList(): List<BannerResponse>
}