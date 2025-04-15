package com.yongjincompany.core.data.local.datasource

import com.yongjincompany.core.data.local.dao.BrandCategoryDao
import com.yongjincompany.core.data.local.entity.BrandCategoryEntity
import javax.inject.Inject

class LocalBrandCategoryDataSourceImpl @Inject constructor(
    private val brandCategoryDao: BrandCategoryDao
) : LocalBrandCategoryDataSource {
    override suspend fun selectAllFromBrandCategoryTable(): List<BrandCategoryEntity> =
        brandCategoryDao.selectAllFromBrandCategoryTable()

    override suspend fun insertBrandCategory(brandCategory: List<BrandCategoryEntity>) =
        brandCategoryDao.insertBrandCategory(brandCategory)
}