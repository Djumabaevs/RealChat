package com.djumabaevs.realchat.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
    val nestedScrollConnection = remember {
        object: NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y
                if(delta > 0f && lazyListState.firstVisibleItemIndex != 0) {
                    return Offset.Zero
                }
                val newOffset = toolbarOffsetY + delta
                toolbarOffsetY = newOffset.coerceIn(
                    minimumValue = -maxOffset.toPx(),
                    maximumValue = 0f
                )
                expandedRatio = ((toolbarOffsetY + maxOffset.toPx()) / maxOffset.toPx())
                println("EXPANDED RATIO: $expandedRatio")
                return Offset.Zero
            }
        }
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(nestedScrollConnection)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            state = lazyListState
        ) {
            item {
                Spacer(modifier = Modifier.height(
                    toolbarHeightExpanded - ProfilePictureSizeLarge / 2f
                ))
            }
            item {
                ProfileHeaderSection(
                    user = User(
                        profilePictureUrl = "",
                        username = "Bakyt Djumabaev",
                        description = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed\n" +
                                "diam nonumy eirmod tempor invidunt ut labore et dolore \n" +
                                "magna aliquyam erat, sed diam voluptua",
                        followerCount = 234,
                        followingCount = 534,
                        postCount = 65
                    )
                )
            }
            items(20) {
                Spacer(
                    modifier = androidx.compose.ui.Modifier
                        .height(SpaceMedium)
                )
                Post(
                    post = Post(
                        username = "Bakyt Djumabaev",
                        imageUrl = "",
                        profilePictureUrl = "",
                        description = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed\n" +
                                "diam nonumy eirmod tempor invidunt ut labore et dolore \n" +
                                "magna aliquyam erat, sed diam voluptua...",
                        likeCount = 17,
                        commentCount = 7,
                    ),
                    showProfileImage = false,
                    onPostClick = {
                        navController.navigate(Screen.PostDetailScreen.route)
                    },
                )
            }
        }
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
        ) {
            BannerSection(
                modifier = Modifier
                    .height(
                        (bannerHeight * expandedRatio).coerceIn(
                            minimumValue = toolbarHeightCollapsed,
                            maximumValue = bannerHeight
                        )
                    ),
                leftIconModifier = Modifier
                    .graphicsLayer {
                        translationY = (1f - expandedRatio) *
                                -iconCollapsedOffsetY.toPx()
                        translationX = (1f - expandedRatio) *
                                iconHorizontalCenterLength
                    },
                rightIconModifier = Modifier
                    .graphicsLayer {
                        translationY = (1f - expandedRatio) *
                                -iconCollapsedOffsetY.toPx()
                        translationX = (1f - expandedRatio) *
                                -iconHorizontalCenterLength
                    }
            )
            Image(
                painter = painterResource(id = R.drawable.philipp),
                contentDescription = stringResource(id = R.string.profile_image),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .graphicsLayer {
                        translationY = -ProfilePictureSizeLarge.toPx() / 2f -
                                (1f - expandedRatio) * imageCollapsedOffsetY.toPx()
                        transformOrigin = TransformOrigin(
                            pivotFractionX = 0.5f,
                            pivotFractionY = 0f
                        )
                        val scale = 0.5f + expandedRatio * 0.5f
                        scaleX = scale
                        scaleY = scale
                    }
                    .size(ProfilePictureSizeLarge)
                    .clip(CircleShape)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colors.onSurface,
                        shape = CircleShape
                    )
            )
        }
    }
}