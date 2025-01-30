package com.yongjincompany.core.data.repository

import com.yongjincompany.core.data.remote.api.ShoesApi
import com.yongjincompany.core.data.remote.mapper.responseToEntity
import com.yongjincompany.core.domain.repository.ShoesRepository
import com.yongjincompany.core.model.Shoes
import javax.inject.Inject

internal class ShoesRepositoryImpl @Inject constructor(
    private val shoesApi: ShoesApi
) : ShoesRepository {
    override suspend fun fetchAllShoesList(): List<Shoes> {
        return shoesApi.fetchAllShoesList()
            .map { it.responseToEntity() }
    }
}