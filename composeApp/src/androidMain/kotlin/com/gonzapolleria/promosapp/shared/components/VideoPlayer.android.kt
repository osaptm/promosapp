package com.gonzapolleria.promosapp.shared.components


import android.widget.VideoView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView


@Composable
actual fun VideoPlayer(modifier: Modifier, videoURL: String) {
    if(videoURL.isNotBlank()) {
        AndroidView(modifier = modifier, factory = { context ->
            val videoView = VideoView(context)
            videoView.apply {
                setVideoPath(videoURL)
                setMediaController(
                    android.widget.MediaController(context).apply { setAnchorView(videoView) })
                start()
            }
        })
    }
}