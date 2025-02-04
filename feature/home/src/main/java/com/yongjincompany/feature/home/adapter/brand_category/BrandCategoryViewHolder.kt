package com.yongjincompany.feature.home.adapter.brand_category

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yongjincompany.core.model.BrandCategory
import com.yongjincompany.feature.home.databinding.ItemBrandCategoryBinding

internal class BrandCategoryViewHolder(
    private val binding: ItemBrandCategoryBinding
) : RecyclerView.ViewHolder(binding.root) {

    private val brandCategoryAdapter = BrandCategoryAdapter()

    init {
        binding.rvBrandCategory.apply {
            adapter = brandCategoryAdapter
            layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    fun bind(brandCategories: List<BrandCategory>) {
        brandCategoryAdapter.submitList(brandCategories)
    }
}