package com.djumabaevs.realchat.core.domain.states

data class StandardTextFieldState(
    val text: String = "",
    val error: Error? = null
)