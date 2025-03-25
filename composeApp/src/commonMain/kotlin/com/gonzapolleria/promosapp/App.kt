package com.gonzapolleria.promosapp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import com.gonzapolleria.promosapp.navigation.NavigationWrapper
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        NavigationWrapper()
    }
}