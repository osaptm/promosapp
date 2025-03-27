package com.gonzapolleria.promosapp.features.initconfigs.data.mappers

import com.gonzapolleria.promosapp.features.initconfigs.domain.entities.ConfigEntityDom
import com.gonzapolleria.promosapp.shared.room.entities.ConfigEntity

object ConfigMapper {
    fun toDomain(entity: ConfigEntity): ConfigEntityDom {
        return ConfigEntityDom(
            id = entity.id,
            login_email = entity.login_email,
            login_apple = entity.login_apple,
            login_google = entity.login_google,
            onboarding_inicio = entity.onboarding_inicio,
            onboarding_afterlogin = entity.onboarding_afterlogin,
            dark_mode = entity.dark_mode,
            logo = entity.logo,
            video = entity.video,
            other_vars = entity.other_vars
        )
    }

    fun toEntityRoom(domain: ConfigEntityDom): ConfigEntity {
        return ConfigEntity(
            id = domain.id,
            login_email= domain.login_email,
            login_apple= domain.login_apple,
            login_google= domain.login_google,
            onboarding_inicio= domain.onboarding_inicio,
            onboarding_afterlogin= domain.onboarding_afterlogin,
            logo= domain.logo,
            video= domain.video,
            dark_mode= domain.dark_mode,
            other_vars= domain.other_vars
        )
    }
}