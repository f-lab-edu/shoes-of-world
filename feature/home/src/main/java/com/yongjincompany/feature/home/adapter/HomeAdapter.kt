package com.yongjincompany.feature.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yongjincompany.core.model.Banner
import com.yongjincompany.core.model.BrandCategory
import com.yongjincompany.core.model.Shoes
import com.yongjincompany.feature.home.ViewType
import com.yongjincompany.feature.home.adapter.banner.BannerViewHolder
import com.yongjincompany.feature.home.adapter.brand_category.BrandCategoryViewHolder
import com.yongjincompany.feature.home.databinding.ItemBannerBinding
import com.yongjincompany.feature.home.databinding.ItemBrandCategoryBinding
import com.yongjincompany.feature.home.databinding.ItemShoesBinding

internal class HomeAdapter : ListAdapter<Any, RecyclerView.ViewHolder>(DiffCallback) {

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return when {
            item is List<*> && item.isNotEmpty() && item.firstOrNull() is Banner -> ViewType.BANNER.type
            item is List<*> && item.isNotEmpty() && item.firstOrNull() is BrandCategory -> ViewType.BRAND_CATEGORY.type
            item is Shoes -> ViewType.SHOES.type
            else -> throw IllegalArgumentException("Unknown view type")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ViewType.BANNER.type -> BannerViewHolder(
                ItemBannerBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )

            ViewType.BRAND_CATEGORY.type -> BrandCategoryViewHolder(
                ItemBrandCategoryBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            ViewType.SHOES.type -> ShoesViewHolder(
                ItemShoesBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )

            else -> throw IllegalArgumentException("Unknown view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is BannerViewHolder -> holder.bind(getItem(position) as? List<Banner> ?: emptyList())
            is BrandCategoryViewHolder -> holder.bind(
                getItem(position) as? List<BrandCategory> ?: emptyList()
            )

            is ShoesViewHolder -> holder.bind(getItem(position) as Shoes)
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Any>() {
        override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
            return when {
                oldItem is List<*> && newItem is List<*> -> oldItem.size == newItem.size
                oldItem is Shoes && newItem is Shoes -> oldItem.id == newItem.id
                else -> false
            }
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
            return when {
                oldItem is Shoes && newItem is Shoes -> oldItem == newItem
                oldItem is List<*> && newItem is List<*> -> {
                    //리스트 내부 요소를 개별적으로 비교할 수 있도록 zip + all을 사용하여 list 2개를 쌍으로 묶고 각각의 item이 같은지 확인
                    oldItem.size == newItem.size && oldItem.zip(newItem)
                        .all { (old, new) -> old == new }
                }

                else -> false
            }
        }

    }
}
