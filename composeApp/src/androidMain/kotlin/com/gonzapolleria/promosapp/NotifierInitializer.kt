package com.gonzapolleria.promosapp

import android.content.Context
import androidx.startup.Initializer
import com.gonzapolleria.promosapp.core.pushnotifications.AppInitializerPush

class NotifierInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        AppInitializerPush.onApplicationStart()
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}