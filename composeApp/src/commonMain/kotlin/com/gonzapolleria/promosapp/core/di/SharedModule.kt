package com.gonzapolleria.promosapp.core.di


import com.gonzapolleria.promosapp.core.network.ApiClientKtor
import com.gonzapolleria.promosapp.core.room.AppDatabase
import com.gonzapolleria.promosapp.shared.room.dao.ConfigDao
import org.koin.core.module.Module
import org.koin.dsl.module

fun sharedModule(): Module = module {
    //KTOR CLIENTE PARA ACCESO A APIS getHttpClient(protocol: URLProtocol, host: String, defaultParams: Map<String, String> = emptyMap() )
    single { ApiClientKtor() }
    //COMPARTE DAO DE CONFIGURACIONES PARA TODA LA APP
    single<ConfigDao> { get<AppDatabase>().getConfigs() }
}