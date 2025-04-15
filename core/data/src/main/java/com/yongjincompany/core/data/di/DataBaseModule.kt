package com.yongjincompany.core.data.di

import android.content.Context
import androidx.room.Room
import com.yongjincompany.core.data.local.SowDatabase
import com.yongjincompany.core.data.local.dao.BannerDao
import com.yongjincompany.core.data.local.dao.BrandCategoryDao
import com.yongjincompany.core.data.local.dao.ShoesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): SowDatabase {
        return Room.databaseBuilder(
            context,
            SowDatabase::class.java,
            "sow_database"
        ).build()
    }

    @Provides
    fun provideShoesDao(database: SowDatabase): ShoesDao {
        return database.shoesDao()
    }

    @Provides
    fun provideBannerDao(database: SowDatabase): BannerDao {
        return database.bannerDao()
    }

    @Provides
    fun provideBrandCategoryDao(database: SowDatabase): BrandCategoryDao {
        return database.brandCategoryDao()
    }
}