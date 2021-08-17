package com.djumabaevs.realchat.presentation.splash

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.navigation.NavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.djumabaevs.realchat.presentation.MainActivity
import com.djumabaevs.realchat.presentation.ui.theme.RealChatTheme
import com.djumabaevs.realchat.presentation.util.Screen
import com.djumabaevs.realchat.util.Constants
import com.djumabaevs.realchat.util.MainCoroutineScopeRule
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class SplashScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @get:Rule
    val coroutineRule = MainCoroutineScopeRule()

    @RelaxedMockK
    lateinit var navController: NavController

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun splashScreen_displaysAndDisappears() = coroutineRule.runBlockingTest {
        composeTestRule.setContent {
            RealChatTheme {
                SplashScreen(navController = navController)
            }
        }
        composeTestRule
            .onNodeWithContentDescription("Logo")
            .assertExists()

        verify {
            navController.popBackStack()
            navController.navigate(Screen.LoginScreen.route)
        }
    }

}