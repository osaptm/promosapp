package com.gonzapolleria.promosapp.core.pushnotifications


import com.mmk.kmpnotifier.notification.NotifierManager
import com.mmk.kmpnotifier.notification.PayloadData

object AppInitializerPush {
    fun onApplicationStart() {
        onApplicationStartPlatformSpecific()
        NotifierManager.addListener(object : NotifierManager.Listener {
            override fun onNewToken(token: String) {
                logMessage("Push Notification onNewToken: $token")
            }

            override fun onPayloadData(data: PayloadData) {
                super.onPayloadData(data)
                logMessage("Push Notification payloadData: $data")
            }
        })
    }
}