package com.yongjincompany.feature.home.adapter.shoes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.yongjincompany.core.domain.entity.Shoes
import com.yongjincompany.feature.home.HomeFragment
import com.yongjincompany.feature.home.databinding.ItemShoesBinding

internal class ShoesAdapter : ListAdapter<Shoes, ShoesViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ShoesViewHolder {
        val binding =
            ItemShoesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ShoesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShoesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return HomeFragment.SHOES_VIEW_TYPE
    }

    private companion object DiffCallback : DiffUtil.ItemCallback<Shoes>() {
        override fun areItemsTheSame(oldItem: Shoes, newItem: Shoes): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Shoes, newItem: Shoes): Boolean {
            return oldItem == newItem
        }
    }
}
