package com.yongjincompany.feature.home.adapter.banner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yongjincompany.core.domain.entity.BannerEntity
import com.yongjincompany.feature.home.databinding.ItemBannerImageBinding

internal class BannerImageAdapter : ListAdapter<BannerEntity, BannerImageAdapter.BannerImageViewHolder>(
    DiffCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerImageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBannerImageBinding.inflate(inflater, parent, false)
        return BannerImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BannerImageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class BannerImageViewHolder(private val binding: ItemBannerImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(banner: BannerEntity) {
            Glide.with(binding.root)
                .load(banner.imageUrl)
                .into(binding.ivBanner)
        }
    }

    private companion object DiffCallback : DiffUtil.ItemCallback<BannerEntity>() {
        override fun areItemsTheSame(oldItem: BannerEntity, newItem: BannerEntity): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: BannerEntity, newItem: BannerEntity): Boolean =
            oldItem == newItem
    }
}