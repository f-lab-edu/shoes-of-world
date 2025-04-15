package com.yongjincompany.core.data.di

import com.yongjincompany.core.data.local.datasource.LocalBannerDataSource
import com.yongjincompany.core.data.local.datasource.LocalBannerDataSourceImpl
import com.yongjincompany.core.data.local.datasource.LocalBrandCategoryDataSource
import com.yongjincompany.core.data.local.datasource.LocalBrandCategoryDataSourceImpl
import com.yongjincompany.core.data.local.datasource.LocalShoesDataSource
import com.yongjincompany.core.data.local.datasource.LocalShoesDataSourceImpl
import com.yongjincompany.core.data.remote.datasource.RemoteBannerDataSource
import com.yongjincompany.core.data.remote.datasource.RemoteBannerDataSourceImpl
import com.yongjincompany.core.data.remote.datasource.RemoteBrandCategoryDataSource
import com.yongjincompany.core.data.remote.datasource.RemoteBrandCategoryDataSourceImpl
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

    @Binds
    abstract fun provideRemoteBannerDataSource(
        remoteBannerDataSourceImpl: RemoteBannerDataSourceImpl
    ): RemoteBannerDataSource

    @Binds
    abstract fun provideLocalBannerDataSource(
        localBannerDataSourceImpl: LocalBannerDataSourceImpl
    ): LocalBannerDataSource

    @Binds
    abstract fun provideRemoteBrandCategoryDataSource(
        remoteBrandCategoryDataSourceImpl: RemoteBrandCategoryDataSourceImpl
    ): RemoteBrandCategoryDataSource

    @Binds
    abstract fun provideLocalBrandCategoryDataSource(
        localBrandCategoryDataSourceImpl: LocalBrandCategoryDataSourceImpl
    ): LocalBrandCategoryDataSource
}