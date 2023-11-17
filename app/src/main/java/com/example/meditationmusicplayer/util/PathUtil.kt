package com.example.meditationmusicplayer.util

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path

fun Path.standardQuadFromTo(from: Offset, to: Offset) {
    quadraticBezierTo(
        x1 = from.x,
        y1 = to.y,
        x2 = (from.x + to.x) / 2f,
        y2 = (from.y + to.y) / 2f
    )
}