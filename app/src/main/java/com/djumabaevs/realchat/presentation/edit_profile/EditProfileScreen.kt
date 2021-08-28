package com.djumabaevs.realchat.presentation.edit_profile

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.djumabaevs.realchat.presentation.ui.theme.ProfilePictureSizeLarge
import com.djumabaevs.realchat.presentation.util.Screen

@Composable
fun Screen.EditProfileScreen(
    navController: NavController,
    viewModel: EditProfileViewModel = hiltViewModel(),
    profilePictureSize: Dp = ProfilePictureSizeLarge
) {

}