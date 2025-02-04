package com.yongjincompany.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.yongjincompany.core.model.Banner
import com.yongjincompany.core.model.BrandCategory
import com.yongjincompany.core.model.Shoes
import com.yongjincompany.feature.home.adapter.HomeAdapter
import com.yongjincompany.feature.home.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var homeAdapter: HomeAdapter
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
        homeAdapter = HomeAdapter()
        binding.rvHome.adapter = homeAdapter
    }

    private fun observe() {
        //FIXME: 우선 api구현되기 전까지 임시로 구현.
        val exampleList = listOf(
            listOf(
                Banner(
                    0,
                    "https://wyta-production-files.s3.ap-northeast-2.amazonaws.com/userspoon/fct_guide_image.png"
                ),
                Banner(
                    1,
                    "https://wyta-production-files.s3.ap-northeast-2.amazonaws.com/userspoon/5s_guide_image.png"
                ),
                Banner(
                    2,
                    "https://wyta-production-files.s3.ap-northeast-2.amazonaws.com/userspoon/5s_guide_image.png"
                ),
                Banner(
                    3,
                    "https://wyta-production-files.s3.ap-northeast-2.amazonaws.com/userspoon/5s_guide_image.png"
                ),
            ),
            listOf(
                BrandCategory(
                    0,
                    "https://wyta-production-files.s3.ap-northeast-2.amazonaws.com/userspoon/fct_guide_image.png"
                ),
                BrandCategory(
                    1,
                    "https://wyta-production-files.s3.ap-northeast-2.amazonaws.com/userspoon/5s_guide_image.png"
                ),
                BrandCategory(
                    2,
                    "https://wyta-production-files.s3.ap-northeast-2.amazonaws.com/userspoon/5s_guide_image.png"
                ),
                BrandCategory(
                    3,
                    "https://wyta-production-files.s3.ap-northeast-2.amazonaws.com/userspoon/5s_guide_image.png"
                ),
                BrandCategory(
                    4,
                    "https://wyta-production-files.s3.ap-northeast-2.amazonaws.com/userspoon/fct_guide_image.png"
                ),
                BrandCategory(
                    5,
                    "https://wyta-production-files.s3.ap-northeast-2.amazonaws.com/userspoon/5s_guide_image.png"
                ),
                BrandCategory(
                    6,
                    "https://wyta-production-files.s3.ap-northeast-2.amazonaws.com/userspoon/5s_guide_image.png"
                ),
                BrandCategory(
                    7,
                    "https://wyta-production-files.s3.ap-northeast-2.amazonaws.com/userspoon/5s_guide_image.png"
                ),
            ),
            Shoes(id = 0, name = "에어포스 1", brandName = "나이키", imageUrl = "", bookmarkCount = 0),
            Shoes(id = 1, name = "에어포스 2", brandName = "나이키", imageUrl = "", bookmarkCount = 0),
            Shoes(id = 2, name = "에어포스 3", brandName = "나이키", imageUrl = "", bookmarkCount = 0)
        )

        homeAdapter.submitList(exampleList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
