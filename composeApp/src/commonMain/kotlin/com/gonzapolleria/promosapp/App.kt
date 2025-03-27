package com.gonzapolleria.promosapp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import com.gonzapolleria.promosapp.navigation.NavigationWrapper

@Composable
fun App() {
    MaterialTheme {
        NavigationWrapper()
    }
}