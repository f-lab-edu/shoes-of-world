package com.yongjincompany.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yongjincompany.core.domain.entity.Banner
import com.yongjincompany.core.domain.entity.Shoes
import com.yongjincompany.core.domain.usecase.banner.FetchBannerListUseCase
import com.yongjincompany.core.domain.usecase.shoes.FetchAllShoesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchAllShoesUseCase: FetchAllShoesListUseCase,
    private val fetchBannerListUseCase: FetchBannerListUseCase
) : ViewModel() {

    private val _shoesListState = MutableStateFlow<List<Shoes>>(emptyList())
    val shoesListState = _shoesListState.asStateFlow()

    private val _bannerListState = MutableStateFlow<List<Banner>>(emptyList())
    val bannerListState = _bannerListState.asStateFlow()

    fun fetchAllShoesList() {
        viewModelScope.launch {
            fetchAllShoesUseCase()
                .flowOn(Dispatchers.IO)
                .collect { shoesList ->
                _shoesListState.value = shoesList
            }
        }
    }

    fun fetchBannerList() {
        viewModelScope.launch {
            fetchBannerListUseCase()
                .flowOn(Dispatchers.IO)
                .collect { bannerList ->
                _bannerListState.value = bannerList
            }
        }
    }
}
