package com.djumabaevs.realchat.presentation.splash

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.djumabaevs.realchat.presentation.MainActivity
import com.djumabaevs.realchat.presentation.ui.theme.RealChatTheme
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class SplashScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun splashScreen_displaysAndDisappears() {
        composeTestRule.setContent {
            RealChatTheme {

            }
        }
    }

}