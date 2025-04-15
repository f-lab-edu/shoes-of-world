package com.yongjincompany.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yongjincompany.core.domain.entity.Banner
import com.yongjincompany.core.domain.entity.BrandCategory
import com.yongjincompany.core.domain.entity.Shoes
import com.yongjincompany.core.domain.usecase.banner.FetchBannerListUseCase
import com.yongjincompany.core.domain.usecase.brand_category.FetchBrandCategoryListUseCase
import com.yongjincompany.core.domain.usecase.shoes.FetchAllShoesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchAllShoesUseCase: FetchAllShoesListUseCase,
    private val fetchBannerListUseCase: FetchBannerListUseCase,
    private val fetchBrandCategoryListUseCase: FetchBrandCategoryListUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun fetchAllShoesList() {
        viewModelScope.launch {
            fetchAllShoesUseCase()
                .flowOn(Dispatchers.IO)
                .collect { shoesList ->
                    _uiState.update { it.copy(shoes = shoesList) }
                }
        }
    }

    fun fetchBannerList() {
        viewModelScope.launch {
            fetchBannerListUseCase()
                .flowOn(Dispatchers.IO)
                .collect { bannerList ->
                    _uiState.update { it.copy(banners = bannerList) }
                }
        }
    }

    fun fetchBrandCategoryList() {
        viewModelScope.launch {
            fetchBrandCategoryListUseCase()
                .flowOn(Dispatchers.IO)
                .collect { brandCategoryList ->
                    _uiState.update { it.copy(brandCategories = brandCategoryList) }
                }
        }
    }
}