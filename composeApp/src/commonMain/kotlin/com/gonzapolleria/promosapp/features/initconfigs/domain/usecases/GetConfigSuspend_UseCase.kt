package com.gonzapolleria.promosapp.features.initconfigs.domain.usecases

import com.gonzapolleria.promosapp.features.initconfigs.domain.entities.ConfigEntityDom
import com.gonzapolleria.promosapp.features.initconfigs.domain.repositories.ConfigRepository
import kotlinx.coroutines.flow.Flow

class GetConfigSuspend_UseCase (private val repository: ConfigRepository){
    operator suspend fun invoke() : List<ConfigEntityDom>? {
        return repository.getConfigSuspend()
    }
}