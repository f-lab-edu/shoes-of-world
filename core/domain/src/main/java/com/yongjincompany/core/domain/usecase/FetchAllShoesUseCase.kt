package com.yongjincompany.core.domain.usecase

import com.yongjincompany.core.domain.entity.ShoesEntity
import com.yongjincompany.core.domain.repository.ShoesRepository
import javax.inject.Inject

class FetchAllShoesUseCase @Inject constructor(
    private val shoesRepository: ShoesRepository
) {
    suspend operator fun invoke(): List<ShoesEntity> =
        shoesRepository.fetchAllShoesList()
}