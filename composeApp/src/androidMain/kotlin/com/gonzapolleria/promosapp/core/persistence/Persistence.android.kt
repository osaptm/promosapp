package com.gonzapolleria.promosapp.core.persistence

import android.content.Context
import android.content.SharedPreferences
import com.gonzapolleria.promosapp.ApplicationContextProvider
import androidx.core.content.edit

actual class SharedPreferencesHelper {

    // Obtener el contexto dentro de la clase
    private val context: Context = ApplicationContextProvider.context

    // SharedPreferences
    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
    }

    actual fun getString(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

    actual fun putString(key: String, value: String) {
        sharedPreferences.edit() { putString(key, value) }
    }

    actual fun remove(key: String) {
        sharedPreferences.edit() { remove(key) }
    }

    actual fun clear() {
        sharedPreferences.edit() { clear() }
    }
}