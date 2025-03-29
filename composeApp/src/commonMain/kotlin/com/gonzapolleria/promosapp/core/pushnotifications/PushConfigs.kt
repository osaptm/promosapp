package com.gonzapolleria.promosapp.core.pushnotifications

expect fun onApplicationStartPlatformSpecific()
expect fun logMessage(message: String)
expect class NotificationPermissionHelper() {
    fun requestNotificationPermission(
        onGranted: () -> Unit,
        onDenied: () -> Unit,
        onError: (Exception) -> Unit
    )
}