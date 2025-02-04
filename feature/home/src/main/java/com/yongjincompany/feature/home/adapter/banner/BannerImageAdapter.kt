package com.yongjincompany.feature.home.adapter.banner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yongjincompany.core.model.Banner
import com.yongjincompany.feature.home.databinding.ItemBannerImageBinding

internal class BannerImageAdapter : ListAdapter<Banner, BannerImageAdapter.BannerViewHolder>(
    DiffCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBannerImageBinding.inflate(inflater, parent, false)
        return BannerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class BannerViewHolder(private val binding: ItemBannerImageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(banner: Banner) {
            Glide.with(binding.root)
                .load(banner.imageUrl)
                .into(binding.ivBanner)
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Banner>() {
        override fun areItemsTheSame(oldItem: Banner, newItem: Banner): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Banner, newItem: Banner): Boolean = oldItem == newItem
    }
}