package com.djumabaevs.realchat.core.presentation.util

import com.djumabaevs.realchat.core.util.UiText

sealed class UiEvent {
    data class SnackbarEvent(val uiText: UiText) : UiEvent()
    data class Navigate(val route: String) : UiEvent()
}