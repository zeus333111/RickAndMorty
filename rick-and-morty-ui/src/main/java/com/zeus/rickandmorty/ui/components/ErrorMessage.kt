package com.zeus.rickandmorty.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun ErrorMessage(modifier: Modifier, error: String, isVisible: Boolean) {
    AnimatedVisibility(modifier = modifier, visible = isVisible, enter = fadeIn(), exit = fadeOut()) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .background(Color.Red)
        ) {
            Text(text = error, style = MaterialTheme.typography.body1, fontWeight = FontWeight.Bold)
        }
    }
}
