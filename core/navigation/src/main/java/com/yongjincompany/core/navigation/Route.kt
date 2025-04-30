package com.yongjincompany.core.navigation

import kotlinx.serialization.Serializable


sealed interface Route {
    @Serializable
    data object Home : Route

    @Serializable
    data class ShoesDetail(val shoesId: Int) : Route
}