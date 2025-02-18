package com.yongjincompany.core.data.di

import com.yongjincompany.core.data.repository.ShoesRepositoryImpl
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
}