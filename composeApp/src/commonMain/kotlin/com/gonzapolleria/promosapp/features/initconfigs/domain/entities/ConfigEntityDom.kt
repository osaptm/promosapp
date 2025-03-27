package com.gonzapolleria.promosapp.features.initconfigs.domain.entities

import com.gonzapolleria.promosapp.shared.room.entities.ConfigEntity
import kotlinx.serialization.Serializable

@Serializable
data class ConfigEntityDom(
    val id: Long,
    val login_email: Boolean,
    val login_apple: Boolean,
    val login_google: Boolean,
    val onboarding_inicio: Boolean,
    val onboarding_afterlogin: Boolean,
    val dark_mode: Boolean,
    val logo: String,
    val video: String,
    val other_vars: String
){
    fun toEntityRoom(): ConfigEntity {
        return ConfigEntity(
            id = id,
            login_email= login_email,
            login_apple= login_apple,
            login_google= login_google,
            onboarding_inicio= onboarding_inicio,
            onboarding_afterlogin= onboarding_afterlogin,
            logo= logo,
            video= video,
            dark_mode= dark_mode,
            other_vars= other_vars
        )

    }
}
