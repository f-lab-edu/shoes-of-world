package com.yongjincompany.feature.home.adapter.brand_category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yongjincompany.core.domain.entity.BrandCategoryEntity
import com.yongjincompany.feature.home.HomeFragment
import com.yongjincompany.feature.home.databinding.ItemBrandCategoryBinding

internal class BrandCategoryAdapter(private val categories : List<BrandCategoryEntity>) : RecyclerView.Adapter<BrandCategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandCategoryViewHolder {
        val binding =
            ItemBrandCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BrandCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BrandCategoryViewHolder, position: Int) {
        holder.bind(categories)
    }

    override fun getItemCount(): Int = 1

    override fun getItemViewType(position: Int): Int {
        return HomeFragment.CATEGORY_VIEW_TYPE
    }
}
