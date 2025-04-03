package com.gonzapolleria.promosapp.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import com.gonzapolleria.promosapp.core.passage.providePassage
import com.gonzapolleria.promosapp.core.pushnotifications.NotificationPermissionHelper
import com.gonzapolleria.promosapp.shared.BackgroundPrimaryColor
import com.gonzapolleria.promosapp.shared.DefaultTextColor
import com.mmk.kmpnotifier.notification.NotifierManager
import com.tweener.passage.Passage
import com.tweener.passage.model.Entrant
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(onSignOut: () -> Unit){
    val buttonsScope = rememberCoroutineScope()
    val passage: Passage = providePassage()
    var entrant by remember { mutableStateOf<Entrant?>(null) }
    val lifecycleOwner = LocalLifecycleOwner.current

    val permissionHelper = NotificationPermissionHelper()
    val token = remember { mutableStateOf("") }

        LaunchedEffect(Unit) {  // "Unit" como key para que solo se ejecute una vez

            token.value = NotifierManager.getPushNotifier().getToken().toString()
            println(token.value)

            permissionHelper.requestNotificationPermission(
                onGranted = {
                    println("Permiso concedido")
                    // Aquí puedes proceder con la configuración de notificaciones
                },
                onDenied = {
                    println("Permiso denegado")
                    // Puedes informar al usuario o intentar convencerlo de activarlas
                },
                onError = { error ->
                    println("Error al solicitar permiso: ${error.message}")
                    // Maneja el error apropiadamente
                }
            )
        }

    LaunchedEffect(passage) {
        lifecycleOwner.repeatOnLifecycle(state = Lifecycle.State.CREATED) {
            entrant = passage.getCurrentUser()
        }
    }

    Column (modifier = Modifier.fillMaxSize().background(BackgroundPrimaryColor), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(entrant?.email?.let { "Entrant email: $it" } ?: "User not logged in", color = DefaultTextColor)
        Button(onClick = {
            buttonsScope.launch {
                passage.signOut()
                onSignOut()
            }
        }) {
            Text("Sign out en HOME")
        }
        Text(text = token.value)
    }
}