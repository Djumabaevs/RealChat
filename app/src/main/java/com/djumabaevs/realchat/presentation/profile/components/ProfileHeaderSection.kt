package com.djumabaevs.realchat.presentation.profile.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.djumabaevs.realchat.domain.models.User

@Composable
fun ProfileHeaderSection(
    user: User,
    modifier: Modifier = Modifier,
    isOwnProfile: Boolean = true,
    onEditClick: () -> Unit = {}
) {}