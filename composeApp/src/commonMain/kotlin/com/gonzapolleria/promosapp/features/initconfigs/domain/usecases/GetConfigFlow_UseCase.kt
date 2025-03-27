package com.gonzapolleria.promosapp.features.initconfigs.domain.usecases

import com.gonzapolleria.promosapp.features.initconfigs.domain.repositories.ConfigRepository
import com.gonzapolleria.promosapp.features.initconfigs.domain.entities.ConfigEntityDom
import kotlinx.coroutines.flow.Flow

class GetConfigFlow_UseCase(private val repository: ConfigRepository){
    operator fun invoke() : Flow<List<ConfigEntityDom>> {
        return repository.getConfigFlow()
    }
}