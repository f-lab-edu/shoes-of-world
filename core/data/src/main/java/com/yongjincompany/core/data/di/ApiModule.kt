package com.yongjincompany.core.data.di

import com.yongjincompany.core.data.remote.api.ShoesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object ApiModule {

    @Provides
    @Singleton
    internal fun provideShoesApi(retrofit: Retrofit): ShoesApi = retrofit.create(ShoesApi::class.java)
}