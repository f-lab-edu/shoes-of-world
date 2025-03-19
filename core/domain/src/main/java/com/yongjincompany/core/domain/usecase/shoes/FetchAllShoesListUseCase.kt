package com.yongjincompany.core.domain.usecase.shoes

import com.yongjincompany.core.domain.entity.Shoes
import com.yongjincompany.core.domain.repository.ShoesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchAllShoesListUseCase @Inject constructor(
    private val shoesRepository: ShoesRepository
) {
     operator fun invoke(): Flow<List<Shoes>> =
        shoesRepository.fetchAllShoesList()
}