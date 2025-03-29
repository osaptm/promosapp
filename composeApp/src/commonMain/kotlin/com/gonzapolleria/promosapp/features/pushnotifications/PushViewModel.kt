package com.gonzapolleria.promosapp.features.pushnotifications

import kotlinx.coroutines.flow.MutableStateFlow
import androidx.lifecycle.ViewModel
import com.mmk.kmpnotifier.notification.NotificationImage
import com.mmk.kmpnotifier.notification.Notifier
import com.mmk.kmpnotifier.notification.NotifierManager
import kotlinx.coroutines.flow.StateFlow

data class PushUiState(
    var title: String = "",
    var content: String = "",
)

class PushScreenModel : ViewModel() {
    private val _state = MutableStateFlow<PushUiState>(PushUiState())
    val state: StateFlow<PushUiState> = _state



    fun onTitleChange(value: String) {
        _state.value = _state.value.copy(title = value)
    }

    fun onContentChange(value: String) {
        _state.value = _state.value.copy(content = value)
    }

    fun sendNotification() {
        val notifier = NotifierManager.getLocalNotifier()
        val currentState = state.value
       /* notifier.notify(
            currentState.title,
            currentState.content
        )*/
        notifier.notify {
            title = "Title from KMPNotifier"
            body = "Body message from KMPNotifier"
            payloadData = mapOf(
                Notifier.KEY_URL to "https://github.com/mirzemehdi/KMPNotifier/",
                "extraKey" to "randomValue"
            )
            image = NotificationImage.Url("https://github.com/user-attachments/assets/a0f38159-b31d-4a47-97a7-cc230e15d30b")
        }
    }
}
