package com.yongjincompany.core.data.remote.datasource

import com.yongjincompany.core.data.remote.model.response.ShoesResponse

interface RemoteShoesDataSource {
    suspend fun fetchAllShoesList(): List<ShoesResponse>
}