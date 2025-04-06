package com.yongjincompany.feature.home

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.yongjincompany.core.designsystem.R.*
import com.yongjincompany.core.designsystem.theme.InputText
import com.yongjincompany.core.designsystem.theme.Primary400
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
        modifier = modifier.padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        items(shoesList, key = { it.id }) { shoe ->
            ShoeItem(shoe = shoe)
        }
    }
}

@Composable
fun ShoeItem(modifier: Modifier = Modifier, shoe: Shoes) {
    val context = LocalContext.current

    Column() {
        AsyncImage(
            model = shoe.imageUrl,
            contentDescription = context.getString(R.string.content_description_banner),
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxWidth()
                .height(172.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(modifier.height(8.dp))
        Text(
            text = shoe.brandName,
            style = SowTheme.typography.title2
        )
        Spacer(modifier.height(5.dp))
        Text(
            text = shoe.name,
            style = SowTheme.typography.caption1,
            color = InputText
        )
        Spacer(modifier.height(5.dp))
        Row(
            modifier = modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = modifier.size(12.dp),
                painter = painterResource(id = drawable.ic_bookmark),
                contentDescription = stringResource(R.string.bookmark_image)
            )
            Spacer(modifier.width(4.dp))
            Text(
                text = shoe.bookmarkCount.toString(),
                style = SowTheme.typography.title4,
                color = Primary400
            )
        }

    }
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
fun PreviewShoeItem() {
    SowTheme {
        val mockShoe = Shoes(
            id = 2,
            imageUrl = "https://fastly.picsum.photos/id/496/200/300.jpg?hmac=demLRv0UMwDhQHH6AEmbkJqlYuX27lnRH5N9FYcHBgw",
            brandName = "나이키",
            name = "나이키 에어맥스",
            bookmarkCount = 2
        )
        ShoeItem(shoe = mockShoe)
    }
}