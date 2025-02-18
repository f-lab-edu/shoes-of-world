package com.yongjincompany.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yongjincompany.core.domain.usecase.FetchAllShoesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/*@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchAllShoesUseCase: FetchAllShoesUseCase
) : ViewModel() {
    private val _event = MutableSharedFlow<HomeEvent>()
    val event = _event.asSharedFlow()

    fun fetchAllShoesList() {
        viewModelScope.launch() {
            runCatching {
                fetchAllShoesUseCase()
            }.onSuccess {
                _event.emit(FetchAllShoesListSuccess(it))
            }.onFailure {
                _event.emit(HomeFailed(R.string.cant_load_shoes_list_plz_retry))
            }
        }
    }
}

sealed interface HomeEvent

data class FetchAllShoesListSuccess(val data: List<Shoes>) : HomeEvent
data class HomeFailed(val errorMessage: Int) : HomeEvent*/