package com.gonzapolleria.promosapp.features.initconfigs.di

import org.koin.core.module.Module

fun initConfigs(): List<Module>  {
    return listOf(
        dataModule(),
        domainModule()
    )
}