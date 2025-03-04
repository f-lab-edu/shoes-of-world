package com.yongjincompany.core.data.local.datasource

import com.yongjincompany.core.data.local.dao.ShoesDao
import com.yongjincompany.core.data.local.entity.ShoesEntity
import javax.inject.Inject

class LocalShoesDataSourceImpl @Inject constructor(
    private val shoesDao: ShoesDao
) : LocalShoesDataSource {
    override suspend fun selectAllFromShoesTable(): List<ShoesEntity> =
        shoesDao.selectAllFromShoesTable()

    override suspend fun insertShoes(shoes: List<ShoesEntity>) =
        shoesDao.insertShoes(shoes)
}