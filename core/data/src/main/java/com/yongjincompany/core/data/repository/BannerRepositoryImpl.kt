package com.yongjincompany.core.data.repository

import com.yongjincompany.core.data.local.datasource.LocalBannerDataSource
import com.yongjincompany.core.data.remote.datasource.RemoteBannerDataSource
import com.yongjincompany.core.data.remote.mapper.localEntityToDomainEntity
import com.yongjincompany.core.data.remote.mapper.responseToEntity
import com.yongjincompany.core.data.remote.mapper.responseToLocalEntity
import com.yongjincompany.core.domain.entity.Banner
import com.yongjincompany.core.domain.repository.BannerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BannerRepositoryImpl @Inject constructor(
    private val remoteBannerDataSource: RemoteBannerDataSource,
    private val localBannerDataSource: LocalBannerDataSource
) : BannerRepository {

    override fun fetchBannerList(): Flow<List<Banner>> = flow {
        val bannerList = remoteBannerDataSource.fetchBannerList()

        localBannerDataSource.insertBanner(bannerList.map { it.responseToLocalEntity() })
        emit(bannerList.map { it.responseToEntity() })
    }.catch { exception ->
        //TODO: 추후 에러 핸들링 처리 구현할 때 excpetion도 처리.
        val localData = localBannerDataSource.selectAllFromBannerTable()
        emit(localData.map { it.localEntityToDomainEntity() })
    }
}

