package com.gonzapolleria.promosapp.shared.components


import android.widget.MediaController
import android.widget.VideoView
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
actual fun VideoPlayer(modifier: Modifier, videoURL: String) {
    var isLoading by remember { mutableStateOf(true) }
    if(videoURL.isNotBlank()) {

        Box{
            AndroidView(modifier = modifier, factory = { context ->
                val videoView = VideoView(context)

                videoView.apply {

                    setOnPreparedListener { mp ->
                        isLoading = false
                        mp.setOnInfoListener { _, what, _ ->
                            if (what == android.media.MediaPlayer.MEDIA_INFO_BUFFERING_START) {
                                isLoading = true
                            } else if (what == android.media.MediaPlayer.MEDIA_INFO_BUFFERING_END) {
                                isLoading = false
                            }
                            true
                        }
                    }

                    setVideoPath(videoURL)
                    // Configuración mejorada del MediaController
                    val mediaController = MediaController(context).apply {
                        setAnchorView(videoView)
                        setMediaPlayer(videoView)
                        // Habilitar controles completos
                        isEnabled = true
                        show(0) // Mostrar controles indefinidamente
                    }

                    setMediaController(mediaController)
                    start()
                }
            })
            // Mostrar spinner mientras carga
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

    }
}
