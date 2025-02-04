package com.yongjincompany.feature.home.adapter.banner

import androidx.recyclerview.widget.RecyclerView
import com.yongjincompany.core.model.Banner
import com.yongjincompany.feature.home.databinding.ItemBannerBinding

internal class BannerViewHolder(private val binding: ItemBannerBinding) : RecyclerView.ViewHolder(binding.root) {

    private val imageAdapter = BannerImageAdapter()

    init {
        binding.vpBanner.adapter = imageAdapter
        binding.vpBanner.offscreenPageLimit = 1
    }

    fun bind(banners: List<Banner>) {
        imageAdapter.submitList(banners)
    }
}