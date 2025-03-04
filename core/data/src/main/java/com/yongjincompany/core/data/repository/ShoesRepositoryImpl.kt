package com.yongjincompany.core.data.repository

import com.yongjincompany.core.data.local.datasource.LocalShoesDataSource
import com.yongjincompany.core.data.remote.datasource.RemoteShoesDataSource
import com.yongjincompany.core.data.remote.mapper.localEntityToDomainEntity
import com.yongjincompany.core.data.remote.mapper.responseToEntity
import com.yongjincompany.core.data.remote.mapper.responseToLocalEntity
import com.yongjincompany.core.domain.entity.Shoes
import com.yongjincompany.core.domain.repository.ShoesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ShoesRepositoryImpl @Inject constructor(
    private val remoteShoesDataSource: RemoteShoesDataSource,
    private val localShoesDataSource: LocalShoesDataSource
) : ShoesRepository {
    override suspend fun fetchAllShoesList(): Flow<List<Shoes>> = flow {
        emit(localShoesDataSource.selectAllFromShoesTable().map { it.localEntityToDomainEntity() })

        runCatching {
            remoteShoesDataSource.fetchAllShoesList()
        }.onSuccess { allShoesList ->
            localShoesDataSource.insertShoes(allShoesList.map { shoes -> shoes.responseToLocalEntity() })
            emit(allShoesList.map { it.responseToEntity() })
        }.onFailure {
            //TODO: errorHandling구현하면서 처리 필요.
        }
    }.flowOn(Dispatchers.IO)
}