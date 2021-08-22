package com.djumabaevs.realchat.presentation.profile

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.djumabaevs.realchat.presentation.ui.theme.ProfilePictureSizeLarge
import com.djumabaevs.realchat.presentation.ui.theme.SpaceSmall
import com.djumabaevs.realchat.presentation.util.toPx

@Composable
fun ProfileScreen(navController: NavController) {
    val lazyListState = rememberLazyListState()
    var toolbarOffsetY by remember {
        mutableStateOf(0f)
    }
    val iconHorizontalCenterLength =
        (LocalConfiguration.current.screenWidthDp.dp.toPx() / 4f -
                (ProfilePictureSizeLarge / 4f).toPx() -
                SpaceSmall.toPx()) / 2f
    val iconSizeExpanded = 35.dp
    val toolbarHeightCollapsed = 75.dp
    val imageCollapsedOffsetY = remember {
        (toolbarHeightCollapsed - ProfilePictureSizeLarge / 2f) / 2f
    }
    val iconCollapsedOffsetY = remember {
        (toolbarHeightCollapsed - iconSizeExpanded) / 2f
    }
    val bannerHeight = (LocalConfiguration.current.screenWidthDp / 2.5f).dp
    val toolbarHeightExpanded = remember {
        bannerHeight + ProfilePictureSizeLarge
    }
    val maxOffset = remember {
        toolbarHeightExpanded - toolbarHeightCollapsed
    }
    var expandedRatio by remember {
        mutableStateOf(1f)
    }
}