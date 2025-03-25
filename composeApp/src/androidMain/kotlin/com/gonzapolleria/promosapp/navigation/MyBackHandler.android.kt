package com.gonzapolleria.promosapp.navigation


import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController



@Composable
actual fun MyBackHandler(navController: NavHostController, onShowExitDialog: () -> Unit){
    BackHandler(enabled = true) {
        if (navController.previousBackStackEntry != null) {
            // Si hay una pantalla anterior en la pila, navega hacia atrás
            navController.popBackStack()
        } else {
            // Si no hay una pantalla anterior, muestra un diálogo de confirmación
            println("No hay una pantalla anterior en la pila. Mostrando diálogo de confirmación.")
            onShowExitDialog()
        }
    }
}