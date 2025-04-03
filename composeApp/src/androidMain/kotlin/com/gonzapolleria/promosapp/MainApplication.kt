package com.gonzapolleria.promosapp

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.ContextCompat
import org.koin.android.ext.koin.androidContext
import com.gonzapolleria.promosapp.core.di.initKoin
import com.mmk.kmpnotifier.permission.AndroidPermissionUtil

@SuppressLint("StaticFieldLeak")
object ApplicationContextProvider {
    lateinit var context: Context
        private set
    fun init(context: Context) {
        this.context = context
    }
}

@SuppressLint("StaticFieldLeak")
object ActivityContextProvider {
    lateinit var context: Context
        private set
    fun init(context: Context) {
        this.context = context
    }
}

@SuppressLint("StaticFieldLeak")
object androidPermissionUtilProvider {
    lateinit var permisoProvider: AndroidPermissionUtil
        private set
    fun init(persimosProvider: AndroidPermissionUtil) {
        this.permisoProvider = persimosProvider
    }
    fun hasNotificationPermission(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ContextCompat.checkSelfPermission(
                ActivityContextProvider.context,
                android.Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        } else {
            // En versiones anteriores a Android 13, no se necesita permiso explícito
            true
        }
    }
}

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Inicializar el contexto Aplicacion
        ApplicationContextProvider.init(this)

        // Inicia Koin
       initKoin(
            appDeclaration = { androidContext(this@MainApplication) },
       )

    }
}