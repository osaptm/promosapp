package com.gonzapolleria.promosapp.features.initconfigs.domain.usecases

import com.gonzapolleria.promosapp.features.initconfigs.domain.entities.ConfigEntityDom
import com.gonzapolleria.promosapp.features.initconfigs.domain.repositories.ConfigRepository

class AddConfig_UseCase(private val repository: ConfigRepository) {
    suspend operator fun invoke(config: ConfigEntityDom) {
        repository.addConfig(config)
    }
}