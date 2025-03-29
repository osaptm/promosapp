package com.gonzapolleria.promosapp.core.pushnotifications

import platform.Foundation.NSLog
import com.mmk.kmpnotifier.notification.NotifierManager
import com.mmk.kmpnotifier.notification.configuration.NotificationPlatformConfiguration
import platform.UserNotifications.UNUserNotificationCenter
import platform.UserNotifications.UNAuthorizationOptionAlert
import platform.UserNotifications.UNAuthorizationOptionBadge
import platform.UserNotifications.UNAuthorizationOptionSound


actual fun onApplicationStartPlatformSpecific() {
    NotifierManager.initialize(
        NotificationPlatformConfiguration.Ios(
            showPushNotification = true,
            askNotificationPermissionOnStart = false, //Lo Pedimos el permiso Donde querramosi
            notificationSoundName = null
        )
    )
}
actual fun logMessage(message: String) {
    NSLog(message)
}


// En commonMain
actual class NotificationPermissionHelper actual constructor() {
    actual fun requestNotificationPermission(
        onGranted: () -> Unit,
        onDenied: () -> Unit,
        onError: (Exception) -> Unit
    ) {
        try {
            val center = UNUserNotificationCenter.currentNotificationCenter()
            center.requestAuthorizationWithOptions(
                options = UNAuthorizationOptionAlert or
                        UNAuthorizationOptionBadge or
                        UNAuthorizationOptionSound,
                completionHandler = { granted, error ->
                    if (error != null) {
                        onError(Exception(error.toString()))
                    } else {
                        if (granted) {
                            onGranted()
                        } else {
                            onDenied()
                        }
                    }
                }
            )
        } catch (e: Exception) {
            onError(e)
        }
    }
}