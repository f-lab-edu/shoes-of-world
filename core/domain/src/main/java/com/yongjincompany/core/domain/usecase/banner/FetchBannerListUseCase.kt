package com.yongjincompany.core.domain.usecase.banner

import com.yongjincompany.core.domain.entity.Banner
import com.yongjincompany.core.domain.repository.BannerRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchBannerListUseCase @Inject constructor(
    private val bannerRepository: BannerRepository
) {
    operator fun invoke(): Flow<List<Banner>> =
        bannerRepository.fetchBannerList()
}