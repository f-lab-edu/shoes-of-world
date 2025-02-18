package com.yongjincompany.feature.home.adapter.shoes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.yongjincompany.core.domain.entity.ShoesEntity
import com.yongjincompany.feature.home.HomeFragment
import com.yongjincompany.feature.home.databinding.ItemShoesBinding

internal class ShoesAdapter : ListAdapter<ShoesEntity, ShoesViewHolder>(DiffCallback) {

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

    private companion object DiffCallback : DiffUtil.ItemCallback<ShoesEntity>() {
        override fun areItemsTheSame(oldItem: ShoesEntity, newItem: ShoesEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ShoesEntity, newItem: ShoesEntity): Boolean {
            return oldItem == newItem
        }
    }
}
