package com.gonzapolleria.promosapp.core.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import com.gonzapolleria.promosapp.features.initconfigs.di.initConfigs


fun initKoin(appDeclaration: KoinAppDeclaration = {}) {
    startKoin {
        appDeclaration()
        modules(
            sharedModule() +
            platformModule() +
            // Agregar llamado a cada Feature, Ejemplo: Login, Onboarding ..
            initConfigs()
        )
    }
}

fun initKoinIos() = initKoin(appDeclaration = {})