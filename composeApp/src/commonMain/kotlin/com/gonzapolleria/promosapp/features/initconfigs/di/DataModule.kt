package com.gonzapolleria.promosapp.features.initconfigs.di

import org.koin.core.module.Module
import org.koin.dsl.module
import com.gonzapolleria.promosapp.features.initconfigs.data.remote.ApiServiceConfigs
import com.gonzapolleria.promosapp.features.initconfigs.domain.repositories.ConfigRepository
import com.gonzapolleria.promosapp.features.initconfigs.data.repositories.ConfigRepositoryImpl
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

fun dataModule(): Module = module {
    factory {
        ApiServiceConfigs(get())
    }

    single<ConfigRepository> {
        ConfigRepositoryImpl(get(), get())
    }
}