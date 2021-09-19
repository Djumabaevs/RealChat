package com.djumabaevs.realchat.presentation.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.djumabaevs.realchat.presentation.ui.theme.SpaceLarge
import com.djumabaevs.realchat.R
import com.djumabaevs.realchat.presentation.components.StandardTextField
import com.djumabaevs.realchat.presentation.ui.theme.SpaceMedium


@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = SpaceLarge,
                end = SpaceLarge,
                top = SpaceLarge,
                bottom = 50.dp
            )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
        ) {
            Text(
                text = stringResource(id = androidx.compose.foundation.layout.R.string.register),
                style = MaterialTheme.typography.h1
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = state.emailText,
                onValueChange = {
                    viewModel.onEvent(RegisterEvent.EnteredEmail(it))
                },
                error = when (state.emailError) {
                    RegisterState.EmailError.FieldEmpty -> {
                        stringResource(id = androidx.compose.foundation.layout.R.string.this_field_cant_be_empty)
                    }
                    RegisterState.EmailError.InvalidEmail -> {
                        stringResource(id = androidx.compose.foundation.layout.R.string.not_a_valid_email)
                    }
                    null -> ""
                },
                keyboardType = KeyboardType.Email,
                hint = stringResource(id = androidx.compose.foundation.layout.R.string.email)
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = state.usernameText,
                onValueChange = {
                    viewModel.onEvent(RegisterEvent.EnteredUsername(it))
                },
                error = when (state.usernameError) {
                    RegisterState.UsernameError.FieldEmpty -> {
                        stringResource(id = androidx.compose.foundation.layout.R.string.this_field_cant_be_empty)
                    }
                    RegisterState.UsernameError.InputTooShort -> {
                        stringResource(id = androidx.compose.foundation.layout.R.string.input_too_short, Constants.MIN_USERNAME_LENGTH)
                    }
                    null -> ""
                },
                hint = stringResource(id = androidx.compose.foundation.layout.R.string.username)
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = state.passwordText,
                onValueChange = {
                    viewModel.onEvent(RegisterEvent.EnteredPassword(it))
                },
                hint = stringResource(id = androidx.compose.foundation.layout.R.string.password_hint),
                keyboardType = KeyboardType.Password,
                error = when (state.passwordError) {
                    RegisterState.PasswordError.FieldEmpty -> {
                        stringResource(id = androidx.compose.foundation.layout.R.string.this_field_cant_be_empty)
                    }
                    RegisterState.PasswordError.InputTooShort -> {
                        stringResource(id = androidx.compose.foundation.layout.R.string.input_too_short, Constants.MIN_PASSWORD_LENGTH)
                    }
                    RegisterState.PasswordError.InvalidPassword -> {
                        stringResource(id = androidx.compose.foundation.layout.R.string.invalid_password)
                    }
                    null -> ""
                },
                isPasswordVisible = state.isPasswordVisible,
                onPasswordToggleClick = {
                    viewModel.onEvent(RegisterEvent.TogglePasswordVisibility)
                }
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            Button(
                onClick = {
                    viewModel.onEvent(RegisterEvent.Register)
                },
                modifier = Modifier
                    .align(Alignment.End)
            ) {
                Text(
                    text = stringResource(id = androidx.compose.foundation.layout.R.string.register),
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }
        Text(
            text = buildAnnotatedString {
                append(stringResource(id = androidx.compose.foundation.layout.R.string.already_have_an_account))
                append(" ")
                val signUpText = stringResource(id = androidx.compose.foundation.layout.R.string.sign_in)
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colors.primary
                    )
                ) {
                    append(signUpText)
                }
            },
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clickable {
                    navController.popBackStack()
                }
        )
    }

}