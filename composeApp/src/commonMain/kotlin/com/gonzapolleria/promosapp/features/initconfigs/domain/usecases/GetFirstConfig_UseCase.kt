package com.gonzapolleria.promosapp.features.initconfigs.domain.usecases

import com.gonzapolleria.promosapp.features.initconfigs.domain.entities.ConfigEntityDom
import com.gonzapolleria.promosapp.features.initconfigs.domain.repositories.ConfigRepository

class GetFirstConfig_UseCase (private val repository: ConfigRepository){
    operator suspend fun invoke() : ConfigEntityDom? {
        return repository.getFirstConfig()
    }
}