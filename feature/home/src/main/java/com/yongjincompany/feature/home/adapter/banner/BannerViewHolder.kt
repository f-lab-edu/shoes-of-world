package com.yongjincompany.feature.home.adapter.banner

import androidx.recyclerview.widget.RecyclerView
import com.yongjincompany.core.domain.entity.BannerEntity
import com.yongjincompany.feature.home.databinding.ItemBannerBinding

internal class BannerViewHolder(private val binding: ItemBannerBinding) : RecyclerView.ViewHolder(binding.root) {

    private val bannerImageAdapter = BannerImageAdapter()

    init {
        binding.vpBanner.adapter = bannerImageAdapter
        binding.vpBanner.offscreenPageLimit = 1
    }

    fun bind(banners: List<BannerEntity>) {
        bannerImageAdapter.submitList(banners)
    }
}