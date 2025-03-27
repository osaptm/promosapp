package com.gonzapolleria.promosapp.features.initconfigs.data.repositories
import com.gonzapolleria.promosapp.features.initconfigs.data.mappers.ConfigMapper
import com.gonzapolleria.promosapp.features.initconfigs.data.remote.ApiServiceConfigs
import com.gonzapolleria.promosapp.features.initconfigs.domain.entities.ConfigEntityDom
import com.gonzapolleria.promosapp.features.initconfigs.domain.repositories.ConfigRepository
import com.gonzapolleria.promosapp.features.initconfigs.data.remote.Response.ConfigResponse
import com.gonzapolleria.promosapp.shared.room.dao.ConfigDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext


class ConfigRepositoryImpl(private val configDao: ConfigDao, private val apiService : ApiServiceConfigs): ConfigRepository {
    override suspend fun addConfig(config: ConfigEntityDom) {
        configDao.insert(ConfigMapper.toEntityRoom(config))
    }

    override fun getConfigFlow(): Flow<List<ConfigEntityDom>> = flow {
        // 1. Ejecutar llamada suspend dentro de flow (usando withContext si necesitas cambiar dispatcher)
        val configResponse = withContext(Dispatchers.IO) {
            apiService.getConfigRemote()
        }

        // 2. Si hay respuesta, guardarla en DB
        if (configResponse != null) {
            addConfig(configResponse.toDomain()) // También suspend
        }

        // 3. Emitir los datos locales iniciales
        emitAll(
            configDao.getConfigsFlow().map { configEntities ->
                configEntities.map { ConfigMapper.toDomain(it) }
            }
        )
    }.flowOn(Dispatchers.IO)

    override suspend fun getConfigSuspend(): List<ConfigEntityDom>? {
        insertFirstConfig()
        return configDao.getConfigsSuspend()?.map {
             ConfigMapper.toDomain(it)
        }
    }

    override suspend fun getFirstConfig(): ConfigEntityDom? {
        return configDao.getFirstConfig()?.let { ConfigMapper.toDomain(it) }
    }

    override suspend fun updateConfig(config: ConfigEntityDom) {
        configDao.update(config.toEntityRoom())
    }

    override suspend fun deleteConfig() {
        configDao.deleteConfig()
    }

    private suspend fun insertFirstConfig() : Unit {
        val configResponse = withContext(Dispatchers.IO) {
            apiService.getConfigRemote()
        }
        if (configResponse != null) {
            val firstConfig = getFirstConfig()
            if(firstConfig == null){
                addConfig(configResponse.toDomain())
            }
        }
    }
}