package com.yongjincompany.core.domain.repository

import com.yongjincompany.core.domain.entity.Banner
import kotlinx.coroutines.flow.Flow

interface BannerRepository {
    fun fetchBannerList(): Flow<List<Banner>>
}