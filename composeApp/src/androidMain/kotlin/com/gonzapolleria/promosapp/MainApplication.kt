package com.gonzapolleria.promosapp

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
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