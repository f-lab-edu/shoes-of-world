package com.yongjincompany.feature.home

import com.yongjincompany.core.domain.entity.Banner
import com.yongjincompany.core.domain.entity.BrandCategory
import com.yongjincompany.core.domain.entity.Shoes

data class HomeUiState(
    val shoes: List<Shoes> = emptyList(),
    val banners: List<Banner> = emptyList(),
    val brandCategories: List<BrandCategory> = emptyList()
)