package com.yongjincompany.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.yongjincompany.core.designsystem.theme.SowTheme
import com.yongjincompany.core.domain.entity.Banner
import com.yongjincompany.core.domain.entity.Shoes

@Composable
fun HomeScreen(modifier: Modifier = Modifier, viewModel: HomeViewModel = hiltViewModel()) {
    val shoesList by viewModel.shoesListState.collectAsState()
    val bannerList by viewModel.bannerListState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchAllShoesList()
        viewModel.fetchBannerList()
    }

    Column(modifier) {

        //TODO: top app bar

        //TODO: banner
        HomeBanner(bannerList = bannerList)
        //TODO: category

        //TODO: shoes list
        HomeShoesList(shoesList = shoesList)
    }
}

@Composable
fun HomeBanner(modifier: Modifier = Modifier, bannerList: List<Banner>) {
    Box(modifier = modifier.height(390.dp)) {
        val pagerState = rememberPagerState(pageCount = { bannerList.size })
        val context = LocalContext.current

        HorizontalPager(
            state = pagerState,
            modifier = modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = bannerList[it].imageUrl,
                contentDescription = context.getString(R.string.content_description_banner),
                contentScale = ContentScale.Crop,
                modifier = modifier.fillMaxSize()
            )
        }

    }
}

@Composable
fun HomeShoesList(modifier: Modifier = Modifier, shoesList: List<Shoes>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
    ) {
        items(shoesList, key = { it.id }) { shoe ->
            ShoeItem(shoe)
        }
    }
}

@Composable
fun ShoeItem(shoe: Shoes) {
    Text(text = shoe.name)
}


@Preview
@Composable
fun PreviewHomeBanner() {
    SowTheme {
        val mockBannerList = listOf(
            Banner(
                0,
                "https://fastly.picsum.photos/id/496/200/300.jpg?hmac=demLRv0UMwDhQHH6AEmbkJqlYuX27lnRH5N9FYcHBgw"
            ),
            Banner(
                1,
                "https://fastly.picsum.photos/id/859/200/300.jpg?hmac=Ty9c6r04FYgwfkw5JMqSLG_eMq0RxeaMTAArotTX6Qk"
            ),
            Banner(
                2,
                "https://fastly.picsum.photos/id/179/200/300.jpg?hmac=oo9H3-mvUxV9CjfSms5helxQW-n5PsZLzkg1ko78uFk"
            ),
        )
        HomeBanner(bannerList = mockBannerList)
    }
}


@Preview
@Composable
fun PreviewHomeShoesList() {
    SowTheme {
        val mockShoesList = listOf(
            Shoes(
                id = 0,
                imageUrl = "https://fastly.picsum.photos/id/496/200/300.jpg?hmac=demLRv0UMwDhQHH6AEmbkJqlYuX27lnRH5N9FYcHBgw",
                brandName = "",
                name = "",
                bookmarkCount = 1
            ),
            Shoes(
                id = 1,
                imageUrl = "https://fastly.picsum.photos/id/496/200/300.jpg?hmac=demLRv0UMwDhQHH6AEmbkJqlYuX27lnRH5N9FYcHBgw",
                brandName = "",
                name = "",
                bookmarkCount = 1
            ),
            Shoes(
                id = 2,
                imageUrl = "https://fastly.picsum.photos/id/496/200/300.jpg?hmac=demLRv0UMwDhQHH6AEmbkJqlYuX27lnRH5N9FYcHBgw",
                brandName = "",
                name = "",
                bookmarkCount = 1
            ),
        )
        HomeShoesList(shoesList = mockShoesList)
    }
}


@Preview
@Composable
fun PreviewHomeScreen() {
    SowTheme {
        //HomeScreen()
    }
}