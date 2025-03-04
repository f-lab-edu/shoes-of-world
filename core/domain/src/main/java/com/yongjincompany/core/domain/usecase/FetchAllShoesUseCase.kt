package com.yongjincompany.core.domain.usecase

import com.yongjincompany.core.domain.entity.Shoes
import com.yongjincompany.core.domain.repository.ShoesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchAllShoesUseCase @Inject constructor(
    private val shoesRepository: ShoesRepository
) {
    suspend operator fun invoke(): Flow<List<Shoes>> =
        shoesRepository.fetchAllShoesList()
}