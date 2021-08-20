package com.djumabaevs.realchat.presentation.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.djumabaevs.realchat.presentation.ui.theme.HintGray

@Composable
@Throws(IllegalArgumentException::class)
fun RowScope.StandardBottomNavItem(
    icon: ImageVector? = null,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    selected: Boolean = false,
    alertCount: Int? = null,
    selectedColor: Color = MaterialTheme.colors.primary,
    unselectedColor: Color = HintGray,
    enabled: Boolean = true,
    onClick: () -> Unit
) {

}