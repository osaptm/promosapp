package com.gonzapolleria.promosapp.features.initconfigs.domain.usecases

import com.gonzapolleria.promosapp.features.initconfigs.domain.entities.ConfigEntityDom
import com.gonzapolleria.promosapp.features.initconfigs.domain.repositories.ConfigRepository

class UpdateConfig_UseCase(private val repository: ConfigRepository) {
    suspend operator fun invoke(config: ConfigEntityDom) {
        repository.updateConfig(config)
    }
}