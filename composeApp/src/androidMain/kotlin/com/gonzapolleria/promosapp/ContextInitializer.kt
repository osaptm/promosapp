package com.gonzapolleria.promosapp

import android.content.Context
import androidx.startup.Initializer

lateinit var applicationContext: Context
class ContextInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        applicationContext = context.applicationContext
    }
    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}