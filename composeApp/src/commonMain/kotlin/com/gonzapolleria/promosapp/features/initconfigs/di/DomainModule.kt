package com.gonzapolleria.promosapp.features.initconfigs.di

import com.gonzapolleria.promosapp.features.initconfigs.domain.usecases.AddConfig_UseCase
import com.gonzapolleria.promosapp.features.initconfigs.domain.usecases.DeleteConfig_UseCase
import com.gonzapolleria.promosapp.features.initconfigs.domain.usecases.GetConfigFlow_UseCase
import com.gonzapolleria.promosapp.features.initconfigs.domain.usecases.GetConfigSuspend_UseCase
import com.gonzapolleria.promosapp.features.initconfigs.domain.usecases.GetFirstConfig_UseCase
import com.gonzapolleria.promosapp.features.initconfigs.domain.usecases.UpdateConfig_UseCase
import org.koin.core.module.Module
import org.koin.dsl.module

fun domainModule(): Module = module {
    factory { AddConfig_UseCase(get()) }
    factory { GetConfigFlow_UseCase(get()) }
    factory { UpdateConfig_UseCase(get()) }
    factory { DeleteConfig_UseCase(get()) }
    factory { GetConfigSuspend_UseCase(get()) }
    factory { GetFirstConfig_UseCase(get()) }
}