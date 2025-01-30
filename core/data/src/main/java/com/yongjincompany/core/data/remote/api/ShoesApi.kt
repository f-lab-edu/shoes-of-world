package com.yongjincompany.core.data.remote.api

import com.yongjincompany.core.data.remote.model.response.ShoesResponse
import retrofit2.http.GET

internal interface ShoesApi {
    @GET("shoes/list")
    suspend fun fetchAllShoesList(): List<ShoesResponse>
}