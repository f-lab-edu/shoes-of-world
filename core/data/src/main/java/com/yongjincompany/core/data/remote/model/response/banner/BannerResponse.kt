package com.yongjincompany.core.data.remote.model.response.banner

import kotlinx.serialization.Serializable

@Serializable
data class BannerResponse(
    val id: Int,
    val imageUrl: String
)