package com.gonzapolleria.promosapp.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.gonzapolleria.promosapp.shared.BackgroundPrimaryColor

@Composable
fun LoginScreen(){
    Box(modifier = Modifier.background(BackgroundPrimaryColor).fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(text = "Login", color = Color.Green, fontSize = 25.sp)
    }
}