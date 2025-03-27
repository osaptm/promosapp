package com.gonzapolleria.promosapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.gonzapolleria.promosapp.core.passage.providePassage

class MainActivity : ComponentActivity() {
    //Passage
    private val passage = providePassage()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar el contexto activity
        ActivityContextProvider.init(this)
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
        intent.data?.let {
            passage.handleLink(url = it.toString())
        }
    }
    //Passage
}

