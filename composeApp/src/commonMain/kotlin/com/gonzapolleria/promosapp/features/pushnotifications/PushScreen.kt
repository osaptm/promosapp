package com.gonzapolleria.promosapp.features.pushnotifications

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gonzapolleria.promosapp.shared.components.AppBar
import com.mmk.kmpnotifier.notification.NotifierManager
import kotlinx.coroutines.launch

@Composable
fun PushScreen() {
    val screenModel = PushScreenModel()
    val state by screenModel.state.collectAsStateWithLifecycle()

    val pushScope = rememberCoroutineScope()
    val token = remember { mutableStateOf("") }
    pushScope.launch {
        token.value = NotifierManager.getPushNotifier().getToken().toString()
    }


    Scaffold(
        topBar = { AppBar(title = "Notifications") },
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                value = state.title,
                label = { Text("Title") },
                onValueChange = {
                    screenModel.onTitleChange(it)
                }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                value = state.content,
                label = { Text("Content") },
                onValueChange = {
                    screenModel.onContentChange(it)
                }
            )

            Button(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                shape = RectangleShape,
                onClick ={
                    screenModel.sendNotification()
                }
            ) {
                Text("Send notification")
            }

            Text(token.value)
            println(token.value)
        }
    }
}
