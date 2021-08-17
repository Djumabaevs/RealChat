package com.djumabaevs.realchat.presentation.splash

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.NavController
import com.djumabaevs.realchat.presentation.MainActivity
import com.djumabaevs.realchat.presentation.ui.theme.RealChatTheme
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SplashScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @RelaxedMockK
    lateinit var navController: NavController

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun splashScreen_displaysAndDisappears() {
        composeTestRule.setContent {
            RealChatTheme {
                SplashScreen(navController = navController)
            }
        }
    }

}