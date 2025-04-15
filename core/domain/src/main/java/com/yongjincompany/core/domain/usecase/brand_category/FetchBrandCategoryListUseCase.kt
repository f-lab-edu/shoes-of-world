package com.yongjincompany.core.domain.usecase.brand_category

import com.yongjincompany.core.domain.entity.BrandCategory
import com.yongjincompany.core.domain.repository.BrandCategoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchBrandCategoryListUseCase @Inject constructor(
    private val brandCategoryRepository: BrandCategoryRepository
) {
    operator fun invoke(): Flow<List<BrandCategory>> =
        brandCategoryRepository.fetchBrandCategoryList()
 }