package com.yongjincompany.core.data.di

import com.yongjincompany.core.data.remote.api.ShoesApi
import com.yongjincompany.core.data.repository.ShoesRepositoryImpl
import com.yongjincompany.core.domain.repository.ShoesRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {
    @Provides
    @Singleton
    abstract fun provideShoesRepository(shoesRepositoryImpl: ShoesRepositoryImpl): ShoesRepository
}