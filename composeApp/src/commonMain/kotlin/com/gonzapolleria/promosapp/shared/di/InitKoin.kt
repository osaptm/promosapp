package com.gonzapolleria.promosapp.shared.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration


fun initKoin(appDeclaration: KoinAppDeclaration = {}) {
    startKoin {
        appDeclaration()
        modules(
            sharedModule() +
            platformModule()
            // Agregar llamado a cada Modulo, Ejemplo: Login, Onboarding ..
        )
    }
}

fun initKoinIos() = initKoin(appDeclaration = {})