package com.yongjincompany.core.data.repository

import com.yongjincompany.core.data.remote.datasource.RemoteShoesDataSource
import com.yongjincompany.core.data.remote.mapper.responseToEntity
import com.yongjincompany.core.domain.repository.ShoesRepository
import com.yongjincompany.core.model.Shoes
import javax.inject.Inject

class ShoesRepositoryImpl @Inject constructor(
    private val remoteShoesDataSource: RemoteShoesDataSource
) : ShoesRepository {
    override suspend fun fetchAllShoesList(): List<Shoes> {
        return remoteShoesDataSource.fetchAllShoesList().map { it.responseToEntity() }
    }

}