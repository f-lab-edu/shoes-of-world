package com.yongjincompany.feature.home.adapter.brand_category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yongjincompany.core.domain.entity.BrandCategoryEntity
import com.yongjincompany.feature.home.databinding.ItemBrandCategoryImageBinding

internal class BrandCategoryImageAdapter :
    ListAdapter<BrandCategoryEntity, BrandCategoryImageAdapter.BrandCategoryImageViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BrandCategoryImageViewHolder {
        val binding =
            ItemBrandCategoryImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return BrandCategoryImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BrandCategoryImageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class BrandCategoryImageViewHolder(
        private val binding: ItemBrandCategoryImageBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: BrandCategoryEntity) {
            Glide.with(binding.ivBrandCategory.context)
                .load(item.imageUrl)
                .into(binding.ivBrandCategory)
        }
    }

    private companion object DiffCallback : DiffUtil.ItemCallback<BrandCategoryEntity>() {
        override fun areItemsTheSame(oldItem: BrandCategoryEntity, newItem: BrandCategoryEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: BrandCategoryEntity, newItem: BrandCategoryEntity): Boolean {
            return oldItem == newItem
        }
    }
}
