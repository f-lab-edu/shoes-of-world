package com.yongjincompany.core.data.di

import com.yongjincompany.core.data.local.datasource.LocalShoesDataSource
import com.yongjincompany.core.data.local.datasource.LocalShoesDataSourceImpl
import com.yongjincompany.core.data.remote.datasource.RemoteShoesDataSource
import com.yongjincompany.core.data.remote.datasource.RemoteShoesDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun provideRemoteShoesDataSource(
        remoteShoesDataSourceImpl: RemoteShoesDataSourceImpl
    ): RemoteShoesDataSource

    @Binds
    abstract fun provideLocalShoesDataSource(
        localShoesDataSourceImpl: LocalShoesDataSourceImpl
    ): LocalShoesDataSource
}