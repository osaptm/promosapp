package com.gonzapolleria.promosapp.features.initconfigs.data.remote.Response

import com.gonzapolleria.promosapp.features.initconfigs.domain.entities.ConfigEntityDom
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigResponse(
    @SerialName("login_email") val login_email: Boolean,
    @SerialName("login_apple") val login_apple: Boolean,
    @SerialName("login_google") val login_google: Boolean,
    @SerialName("onboarding_inicio") val onboarding_inicio: Boolean,
    @SerialName("onboarding_afterlogin") val onboarding_afterlogin: Boolean,
    @SerialName("dark_mode") val dark_mode: Boolean,
    @SerialName("logo") val logo: String,
    @SerialName("video") val video: String,
    @SerialName("others_vars") val others_vars: String
){
    fun toDomain(): ConfigEntityDom {
        return ConfigEntityDom(
            id = 0L,
            login_email = login_email,
            login_apple = login_apple,
            login_google = login_google,
            onboarding_inicio = onboarding_inicio,
            onboarding_afterlogin = onboarding_afterlogin,
            dark_mode = dark_mode,
            logo = logo,
            video = video,
            other_vars = others_vars
        )
    }
}
