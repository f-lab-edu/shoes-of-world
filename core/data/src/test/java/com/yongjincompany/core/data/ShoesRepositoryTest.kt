package com.yongjincompany.core.data

import com.yongjincompany.core.data.remote.datasource.RemoteShoesDataSource
import com.yongjincompany.core.data.remote.mapper.responseToEntity
import com.yongjincompany.core.data.remote.model.response.ShoesResponse
import com.yongjincompany.core.data.repository.ShoesRepositoryImpl
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk

class ShoesRepositoryTest : BehaviorSpec({
    val remoteShoesDataSource: RemoteShoesDataSource = mockk()
    val shoesRepository = ShoesRepositoryImpl(remoteShoesDataSource)

    Given("remoteShoesDataSource가 신발 전체 목록을 반환할 시") {
        val mockResponse = listOf(
            ShoesResponse(
                id = 1,
                name = "Nike Air",
                brandName = "Nike",
                imageUrl = "https://",
                bookmarkCount = 100
            ),
            ShoesResponse(
                id = 2,
                name = "Adidas Boost",
                brandName = "Adidas",
                imageUrl = "https://",
                bookmarkCount = 200
            )
        )

        coEvery { remoteShoesDataSource.fetchAllShoesList() } returns mockResponse

        When("repository의 fetchAllShoesList를 호출하면") {
            val result = shoesRepository.fetchAllShoesList()
            val expectedEntities = mockResponse.map { it.responseToEntity() }

            Then("entity를 반환해야한다") {
                result shouldBe expectedEntities
                coVerify(exactly = 1) { remoteShoesDataSource.fetchAllShoesList() }
            }
        }
    }
})