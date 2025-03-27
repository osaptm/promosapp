package com.gonzapolleria.promosapp.features.initconfigs.domain.repositories

import com.gonzapolleria.promosapp.features.initconfigs.domain.entities.ConfigEntityDom
import com.gonzapolleria.promosapp.features.initconfigs.data.remote.Response.ConfigResponse
import kotlinx.coroutines.flow.Flow

interface ConfigRepository {
    suspend fun addConfig(config: ConfigEntityDom)
    fun getConfigFlow() : Flow<List<ConfigEntityDom>>
    suspend fun getConfigSuspend() : List<ConfigEntityDom>?
    suspend fun getFirstConfig() : ConfigEntityDom?
    suspend fun updateConfig(config: ConfigEntityDom)
    suspend fun deleteConfig()
}