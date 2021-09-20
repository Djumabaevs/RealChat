package com.djumabaevs.realchat.presentation.activity

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.djumabaevs.realchat.presentation.components.StandardToolbar
import kotlin.random.Random
import com.djumabaevs.realchat.R
import com.djumabaevs.realchat.domain.models.Activity
import com.djumabaevs.realchat.domain.util.ActivityAction
import com.djumabaevs.realchat.core.util.DateFormatUtil
import com.djumabaevs.realchat.feature_activtiy.presentation.activity.ActivityViewModel
import com.djumabaevs.realchat.presentation.activity.components.ActivityItem
import com.djumabaevs.realchat.presentation.ui.theme.SpaceMedium

@Composable
fun ActivityScreen(
    navController: NavController,
    viewModel: ActivityViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        StandardToolbar(
            navController = navController,
            title = {
                Text(
                    text = stringResource(id = R.string.your_activity),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            },
            modifier = Modifier.fillMaxWidth(),
            showBackArrow = false,
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(SpaceMedium)
        ) {
            items(20) {
                ActivityItem(
                    activity = Activity(
                        "Bakyt Djumabaev",
                        actionType = if(Random.nextInt(2) == 0) {
                            ActivityAction.LikedPost
                        } else ActivityAction.CommentedOnPost,
                        formattedTime = DateFormatUtil.timestampToFormattedString(
                            timestamp = System.currentTimeMillis(),
                            pattern = "MMM dd, HH:mm"
                        )
                    ),
                )
                if(it < 19) {
                    Spacer(modifier = androidx.compose.ui.Modifier.height(SpaceMedium))
                }
            }
        }
    }
}