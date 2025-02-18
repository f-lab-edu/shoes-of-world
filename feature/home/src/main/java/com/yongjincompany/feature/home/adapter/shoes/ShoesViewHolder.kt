package com.yongjincompany.feature.home.adapter.shoes

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yongjincompany.core.domain.entity.ShoesEntity
import com.yongjincompany.feature.home.databinding.ItemShoesBinding

internal class ShoesViewHolder(private val binding: ItemShoesBinding) : RecyclerView.ViewHolder(binding.root) {
    //TODO: 여기도 새로 recyclerview 추가해야함
    fun bind(data: ShoesEntity) {
        Glide.with(binding.root.context)
            .load(data.imageUrl)
            .into(binding.ivShoes)

        binding.tvShoes.text = data.name
        binding.tvBrand.text = data.brandName
        binding.tvBookmark.text = data.bookmarkCount.toString()
    }
}
