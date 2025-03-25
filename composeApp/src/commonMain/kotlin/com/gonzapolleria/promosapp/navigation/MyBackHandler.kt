package com.gonzapolleria.promosapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
expect fun MyBackHandler(navController: NavHostController, onShowExitDialog: () -> Unit)