package com.yongjincompany.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import com.yongjincompany.core.domain.entity.BannerEntity
import com.yongjincompany.core.domain.entity.BrandCategoryEntity
import com.yongjincompany.core.domain.entity.ShoesEntity
import com.yongjincompany.feature.home.adapter.banner.BannerAdapter
import com.yongjincompany.feature.home.adapter.brand_category.BrandCategoryAdapter
import com.yongjincompany.feature.home.adapter.shoes.ShoesAdapter
import com.yongjincompany.feature.home.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var homeAdapter: ShoesAdapter
    //private val vm: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        observe()

    }

    private fun init() {
        val bannerAdapter = BannerAdapter(bannerItemList)
        val brandCategoryAdapter = BrandCategoryAdapter(brandCategoryItemList)
        val shoesAdapter = ShoesAdapter()

        shoesAdapter.submitList(shoesItemList)

        val concatAdapter = ConcatAdapter(bannerAdapter, brandCategoryAdapter, shoesAdapter)

        binding.rvHome.apply {
            layoutManager = GridLayoutManager(requireContext(), 2).apply {
                spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        return when (concatAdapter.getItemViewType(position)) {
                            BANNER_VIEW_TYPE, CATEGORY_VIEW_TYPE -> 2
                            else -> 1
                        }
                    }
                }
            }
            adapter = concatAdapter
        }
    }

    private fun observe() {
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val BANNER_VIEW_TYPE = 0
        const val CATEGORY_VIEW_TYPE = 1
        const val SHOES_VIEW_TYPE = 2

        private val bannerItemList = listOf(
            BannerEntity(
                0,
                "https://wyta-production-files.s3.ap-northeast-2.amazonaws.com/userspoon/fct_guide_image.png"
            ),
            BannerEntity(
                1,
                "https://wyta-production-files.s3.ap-northeast-2.amazonaws.com/userspoon/5s_guide_image.png"
            ),
            BannerEntity(
                2,
                "https://wyta-production-files.s3.ap-northeast-2.amazonaws.com/userspoon/5s_guide_image.png"
            ),
            BannerEntity(
                3,
                "https://wyta-production-files.s3.ap-northeast-2.amazonaws.com/userspoon/5s_guide_image.png"
            ),
        )

        private val brandCategoryItemList = listOf(
            BrandCategoryEntity(
                0,
                "https://wyta-production-files.s3.ap-northeast-2.amazonaws.com/userspoon/fct_guide_image.png"
            ),
            BrandCategoryEntity(
                1,
                "https://wyta-production-files.s3.ap-northeast-2.amazonaws.com/userspoon/5s_guide_image.png"
            ),
            BrandCategoryEntity(
                2,
                "https://wyta-production-files.s3.ap-northeast-2.amazonaws.com/userspoon/5s_guide_image.png"
            ),
            BrandCategoryEntity(
                3,
                "https://wyta-production-files.s3.ap-northeast-2.amazonaws.com/userspoon/5s_guide_image.png"
            ),
            BrandCategoryEntity(
                4,
                "https://wyta-production-files.s3.ap-northeast-2.amazonaws.com/userspoon/fct_guide_image.png"
            ),
            BrandCategoryEntity(
                5,
                "https://wyta-production-files.s3.ap-northeast-2.amazonaws.com/userspoon/5s_guide_image.png"
            ),
            BrandCategoryEntity(
                6,
                "https://wyta-production-files.s3.ap-northeast-2.amazonaws.com/userspoon/5s_guide_image.png"
            ),
            BrandCategoryEntity(
                7,
                "https://wyta-production-files.s3.ap-northeast-2.amazonaws.com/userspoon/5s_guide_image.png"
            ),
        )

        private val shoesItemList = listOf(
            ShoesEntity(
                id = 0,
                name = "에어포스 1",
                brandName = "나이키",
                imageUrl = "",
                bookmarkCount = 0
            ),
            ShoesEntity(
                id = 1,
                name = "용진포스 2",
                brandName = "퓨마",
                imageUrl = "",
                bookmarkCount = 100
            ),
            ShoesEntity(
                id = 2,
                name = "공기포스 3",
                brandName = "아디다스",
                imageUrl = "",
                bookmarkCount = 0
            ),
            ShoesEntity(
                id = 3,
                name = "허헣 3",
                brandName = "프로스펙스",
                imageUrl = "",
                bookmarkCount = 0
            )
        )
    }
}
