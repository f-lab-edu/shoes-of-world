package com.yongjincompany.core.domain.usecase

import com.yongjincompany.core.domain.repository.ShoesRepository
import com.yongjincompany.core.model.Shoes
import javax.inject.Inject

class FetchAllShoesUseCase @Inject constructor(
    private val shoesRepository: ShoesRepository
) {
    suspend operator fun invoke(): List<Shoes> =
        shoesRepository.fetchAllShoesList()
}