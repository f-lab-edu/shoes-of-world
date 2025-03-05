package com.yongjincompany.core.designsystem.theme


import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.yongjincompany.core.designsystem.R

private val PretendardStyle = TextStyle(
    fontFamily = FontFamily(
        Font(R.font.pretendard_bold, FontWeight.Bold, FontStyle.Normal),
        Font(R.font.pretendard_semibold, FontWeight.SemiBold, FontStyle.Normal),
        Font(R.font.pretendard_medium, FontWeight.Medium, FontStyle.Normal),
        Font(R.font.pretendard_regular, FontWeight.Normal, FontStyle.Normal)
    ),
    fontWeight = FontWeight.Normal,
    color = White
)

internal val Typography = SowTypography(
    head1 = PretendardStyle.copy(
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
    ),
    head2 = PretendardStyle.copy(
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    ),
    title1 = PretendardStyle.copy(
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold
    ),
    title2 = PretendardStyle.copy(
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold
    ),
    title3 = PretendardStyle.copy(
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold
    ),
    title4 = PretendardStyle.copy(
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold
    ),
    body1 = PretendardStyle.copy(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium
    ),
    caption1 = PretendardStyle.copy(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal
    ),
    caption2 = PretendardStyle.copy(
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal
    )
)

@Immutable
data class SowTypography(
    val head1: TextStyle,
    val head2: TextStyle,
    val title1: TextStyle,
    val title2: TextStyle,
    val title3: TextStyle,
    val title4: TextStyle,
    val body1: TextStyle,
    val caption1: TextStyle,
    val caption2: TextStyle
)

val LocalTypography = staticCompositionLocalOf {
    SowTypography(
        head1 = PretendardStyle,
        head2 = PretendardStyle,
        title1 = PretendardStyle,
        title2 = PretendardStyle,
        title3 = PretendardStyle,
        title4 = PretendardStyle,
        body1 = PretendardStyle,
        caption1 = PretendardStyle,
        caption2 = PretendardStyle
    )
}