package com.yongjincompany.feature.home.adapter.banner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yongjincompany.core.domain.entity.BannerEntity
import com.yongjincompany.feature.home.HomeFragment
import com.yongjincompany.feature.home.databinding.ItemBannerBinding


internal class BannerAdapter(private val banners: List<BannerEntity>) :
    RecyclerView.Adapter<BannerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val binding = ItemBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BannerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bind(banners)
    }

    override fun getItemCount(): Int = 1

    override fun getItemViewType(position: Int): Int {
        return HomeFragment.BANNER_VIEW_TYPE
    }
}

