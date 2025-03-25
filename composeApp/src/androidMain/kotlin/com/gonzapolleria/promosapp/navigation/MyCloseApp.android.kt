package com.gonzapolleria.promosapp.navigation


import android.content.Context
import android.content.ContextWrapper
import androidx.activity.ComponentActivity
import com.gonzapolleria.promosapp.ApplicationContextProvider

fun Context.getActivity(): ComponentActivity? {
    return when (this) {
        is ComponentActivity -> this // Si el contexto es una ComponentActivity, lo retornamos directamente
        is ContextWrapper -> baseContext.getActivity() // Si es un ContextWrapper, verificamos su baseContext
        else -> null // Si no es una Activity, retornamos null
    }
}



actual fun MyCloseApp() {
    val activity: ComponentActivity? by lazy {
        ApplicationContextProvider.context.getActivity()
    }
    activity?.finishAffinity()
    System.exit(0)
}