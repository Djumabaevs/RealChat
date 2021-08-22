package com.djumabaevs.realchat.presentation.profile.components

import android.graphics.Paint
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.djumabaevs.realchat.domain.models.User
import com.djumabaevs.realchat.presentation.ui.theme.SpaceSmall

@Composable
fun ProfileHeaderSection(
    user: User,
    modifier: Modifier = Modifier,
    isOwnProfile: Boolean = true,
    onEditClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .offset(
                x =
                    if(isOwnProfile) {
                        (30.dp + SpaceSmall) / 2F
                    } else 0.dp
            )
    ) {
            Text(
                text = user.username,
                style = MaterialTheme.typography.h1.copy(
                    fontSize = 24.sp
                ),
                textAlign = TextAlign.Center
            )
            if(isOwnProfile) {
                Spacer(modifier = Modifier.width(SpaceSmall))
            }


        }

    }
}