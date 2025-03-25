package com.gonzapolleria.promosapp.shared.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("config")
data class ConfigEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val darkMode: Boolean
)
