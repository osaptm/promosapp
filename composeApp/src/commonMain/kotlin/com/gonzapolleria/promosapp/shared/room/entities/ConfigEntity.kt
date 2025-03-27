package com.gonzapolleria.promosapp.shared.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("config")
data class ConfigEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val login_email: Boolean = true,
    val login_apple: Boolean = true,
    val login_google: Boolean = true,
    val onboarding_inicio: Boolean = true,
    val onboarding_afterlogin: Boolean = true,
    val dark_mode: Boolean = true,
    val logo: String = "",
    val video: String = "",
    val other_vars: String = ""
)
