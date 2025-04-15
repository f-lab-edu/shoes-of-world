package com.yongjincompany.core.data.di

import com.yongjincompany.core.data.repository.BannerRepositoryImpl
import com.yongjincompany.core.data.repository.BrandCategoryRepositoryImpl
import com.yongjincompany.core.data.repository.ShoesRepositoryImpl
import com.yongjincompany.core.domain.repository.BannerRepository
import com.yongjincompany.core.domain.repository.BrandCategoryRepository
import com.yongjincompany.core.domain.repository.ShoesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindShoesRepository(shoesRepositoryImpl: ShoesRepositoryImpl): ShoesRepository

    @Binds
    @Singleton
    abstract fun bindBannerRepository(bannerRepositoryImpl: BannerRepositoryImpl): BannerRepository

    @Binds
    @Singleton
    abstract fun bindBrandCategoryRepository(brandCategoryRepositoryImpl: BrandCategoryRepositoryImpl): BrandCategoryRepository
}