package com.gonzapolleria.promosapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.gonzapolleria.promosapp.core.passage.providePassage
import com.mmk.kmpnotifier.permission.AndroidPermissionUtil
import com.mmk.kmpnotifier.permission.permissionUtil

class MainActivity : ComponentActivity() {
    //Passage
    private val passage = providePassage()
    //Para permisos de notificaciones
    private val permissionUtil: AndroidPermissionUtil by permissionUtil()




    /*pedir permisos de notificaciones al inicial app
    override fun onStart() {
        super.onStart()
        permissionUtil.askNotificationPermission { isSuccess ->
            if (isSuccess) return@askNotificationPermission
            Toast.makeText(this, "Permissions is required", Toast.LENGTH_SHORT).show()
        }
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar el contexto activity
        ActivityContextProvider.init(this)
        androidPermissionUtilProvider.init(permissionUtil)
        // Splash
        installSplashScreen()
        //Passage
        handleUniversalLink(intent = intent)

        setContent {
            App()
        }
    }


    //Passage
    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleUniversalLink(intent = intent)
    }
    private fun handleUniversalLink(intent: Intent) {
        intent.data?.let { passage.handleLink(url = it.toString()) }
    }
    //Passage

}

