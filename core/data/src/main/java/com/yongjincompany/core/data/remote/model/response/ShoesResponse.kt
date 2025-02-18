package com.yongjincompany.core.data.remote.model.response

import kotlinx.serialization.Serializable

@Serializable
data class ShoesResponse(
    val id: Int,
    val name: String,
    val brandName: String,
    val imageUrl: String,
    val bookmarkCount: Int
)
