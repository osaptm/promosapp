package com.gonzapolleria.promosapp.core.pushnotifications

import android.util.Log
import android.widget.Toast
import com.gonzapolleria.promosapp.ActivityContextProvider
import com.mmk.kmpnotifier.notification.NotifierManager
import com.mmk.kmpnotifier.notification.configuration.NotificationPlatformConfiguration
import com.gonzapolleria.promosapp.R
import com.gonzapolleria.promosapp.androidPermissionUtilProvider

actual fun onApplicationStartPlatformSpecific() {
    NotifierManager.initialize(
        configuration = NotificationPlatformConfiguration.Android(
            notificationIconResId = R.drawable.ic_launcher_foreground,
            showPushNotification = true
        )
    )
}
actual fun logMessage(message: String) {
    Log.d("Notifications", message)
}

// En commonMain
actual class NotificationPermissionHelper actual constructor() {
    actual fun requestNotificationPermission(
        onGranted: () -> Unit,
        onDenied: () -> Unit,
        onError: (Exception) -> Unit
    ) {
        try{
            val permissionUtil = androidPermissionUtilProvider.permisoProvider
            val context = ActivityContextProvider.context
            permissionUtil.askNotificationPermission { isSuccess ->
                if (!isSuccess) onGranted()
                else onDenied()
            }
        }catch (error: Exception){
            onError(error)
        }
    }
}
