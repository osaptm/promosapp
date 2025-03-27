package com.gonzapolleria.promosapp.features.login

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.gonzapolleria.promosapp.shared.BackgroundPrimaryColor
import com.gonzapolleria.promosapp.shared.components.VideoPlayer
import com.gonzapolleria.promosapp.shared.room.entities.ConfigEntity

@Composable
fun LoginScreen(firstConfig: ConfigEntity?){

      Column (modifier = Modifier.background(BackgroundPrimaryColor).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally){

            Text(text = "Login", color = Color.Green, fontSize = 25.sp)

            if(firstConfig != null) {

                AsyncImage(
                    model = firstConfig.logo,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.width(30.dp).height(30.dp),
                )


                ElevatedCard(
                    modifier = Modifier.fillMaxWidth().height(300.dp).padding(16.dp)
                        .border(3.dp, Color.Green, CardDefaults.elevatedShape)
                ) {
                    Box(modifier = Modifier.fillMaxSize().background(Color.Black)) {
                        Box(
                            modifier = Modifier.padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {

                           VideoPlayer(
                                modifier = Modifier.fillMaxWidth().height(200.dp),
                                videoURL = firstConfig.video
                            )



                        }
                        Row {
                            Spacer(modifier = Modifier.weight(1f))
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Cerrar",
                                tint = Color.Green,
                                modifier = Modifier
                                    .padding(8.dp)
                                    .size(40.dp)
                                    .clickable {
                                        // Aquí tu acción al hacer clic
                                    }
                            )
                        }
                    }
                }
            }
    }
}