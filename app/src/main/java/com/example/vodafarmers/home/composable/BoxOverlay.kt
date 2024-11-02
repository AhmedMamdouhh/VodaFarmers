package com.example.vodafarmers.home.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun BoxScope.BoxOverlay(
    modifier: Modifier = Modifier,
    color1: Color = Color.Transparent,
    color2: Color = Color.Black.copy(alpha = 0.6f),
    color3: Color = Color.Black.copy(alpha = 0.8f),
) {
    Box(
        modifier = modifier
            .matchParentSize()
            .background(
                Brush.verticalGradient(
                    0.5f to color1,
                    0.8f to color2,
                    1.0f to color3
                )
            )
    )
}