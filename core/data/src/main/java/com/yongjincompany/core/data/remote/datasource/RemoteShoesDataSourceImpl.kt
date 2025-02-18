package com.yongjincompany.core.data.remote.datasource

import com.yongjincompany.core.data.remote.api.ShoesApi
import com.yongjincompany.core.data.remote.model.response.ShoesResponse
import javax.inject.Inject

class RemoteShoesDataSourceImpl @Inject constructor(
    private val shoesApi: ShoesApi
): RemoteShoesDataSource {
    override suspend fun fetchAllShoesList(): List<ShoesResponse> {
        return shoesApi.fetchAllShoesList()
    }
}