package com.gonzapolleria.promosapp.shared.helpers

expect fun currentPlatform(): Platform

enum class Platform {
    ANDROID, IOS
}