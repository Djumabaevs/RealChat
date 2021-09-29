package com.djumabaevs.realchat.feature_post.presentation.person_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.djumabaevs.realchat.core.domain.models.User
import com.djumabaevs.realchat.core.presentation.ui.theme.IconSizeMedium
import com.djumabaevs.realchat.core.presentation.ui.theme.SpaceLarge
import com.djumabaevs.realchat.core.presentation.ui.theme.SpaceMedium
import com.djumabaevs.realchat.core.presentation.components.StandardToolbar
import com.djumabaevs.realchat.core.presentation.components.UserProfileItem
import com.djumabaevs.realchat.R

@ExperimentalMaterialApi
@Composable
fun PersonListScreen(
    onNavigate: (String) -> Unit = {},
    onNavigateUp: () -> Unit = {},
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StandardToolbar(
            onNavigateUp = onNavigateUp,
            showBackArrow = true,
            title = {
                Text(
                    text = stringResource(id = R.string.liked_by),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            }
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(SpaceLarge)
        ) {
            items(10) {
                UserProfileItem(
                    user = User(
                        userId = "6127d2001241f332c88eb9a2",
                        profilePictureUrl = "",
                        username = "Bakyt Djumabaev",
                        description = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed\n" +
                                "diam nonumy eirmod tempor invidunt ut labore et dolore \n" +
                                "magna aliquyam erat, sed diam voluptua",
                        followerCount = 234,
                        followingCount = 534,
                        postCount = 65
                    ),
                    actionIcon = {
                        Icon(
                            imageVector = Icons.Default.PersonAdd,
                            contentDescription = null,
                            tint = MaterialTheme.colors.onBackground,
                            modifier = Modifier.size(IconSizeMedium)
                        )
                    }
                )
                Spacer(modifier = androidx.compose.ui.Modifier.height(SpaceMedium))
            }
        }
    }
}