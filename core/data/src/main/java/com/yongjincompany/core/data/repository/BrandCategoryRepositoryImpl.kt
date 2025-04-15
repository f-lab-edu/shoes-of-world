package com.yongjincompany.core.data.repository

import com.yongjincompany.core.data.local.datasource.LocalBrandCategoryDataSource
import com.yongjincompany.core.data.remote.datasource.RemoteBrandCategoryDataSource
import com.yongjincompany.core.data.remote.mapper.localEntityToDomainEntity
import com.yongjincompany.core.data.remote.mapper.responseToEntity
import com.yongjincompany.core.data.remote.mapper.responseToLocalEntity
import com.yongjincompany.core.domain.entity.BrandCategory
import com.yongjincompany.core.domain.repository.BrandCategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BrandCategoryRepositoryImpl @Inject constructor(
    private val remoteBrandCategoryDataSource: RemoteBrandCategoryDataSource,
    private val localBrandCategoryDataSource: LocalBrandCategoryDataSource
) : BrandCategoryRepository {

    override fun fetchBrandCategoryList(): Flow<List<BrandCategory>> = flow {
        val brandCategoryList = remoteBrandCategoryDataSource.fetchBrandCategoryList()

        localBrandCategoryDataSource.insertBrandCategory(brandCategoryList.map { it.responseToLocalEntity() })
        emit(brandCategoryList.map { it.responseToEntity() })
    }.catch { exception ->
        //TODO: 추후 에러 핸들링 처리 구현할 때 excpetion도 처리.
        val localData = localBrandCategoryDataSource.selectAllFromBrandCategoryTable()
        emit(localData.map { it.localEntityToDomainEntity() })
    }
}