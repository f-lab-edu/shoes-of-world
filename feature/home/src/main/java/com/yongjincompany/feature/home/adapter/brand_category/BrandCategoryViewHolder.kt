package com.yongjincompany.feature.home.adapter.brand_category

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yongjincompany.core.domain.entity.BrandCategoryEntity
import com.yongjincompany.feature.home.databinding.ItemBrandCategoryBinding

internal class BrandCategoryViewHolder(
    private val binding: ItemBrandCategoryBinding
) : RecyclerView.ViewHolder(binding.root) {

    private val brandCategoryImageAdapter = BrandCategoryImageAdapter()

    init {
        binding.rvBrandCategory.apply {
            adapter = brandCategoryImageAdapter
            layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    fun bind(brandCategories: List<BrandCategoryEntity>) {
        brandCategoryImageAdapter.submitList(brandCategories)
    }
}