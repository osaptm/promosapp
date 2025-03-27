package com.gonzapolleria.promosapp.core.di

import org.koin.core.module.Module
import org.koin.dsl.module
import com.gonzapolleria.promosapp.core.room.getDatabaseBuilder
import com.gonzapolleria.promosapp.core.room.getAppDatabase
import com.gonzapolleria.promosapp.core.room.AppDatabase

actual fun platformModule(): Module = module {
    single<AppDatabase> {
        val builder = getDatabaseBuilder()
        getAppDatabase(builder)
    }
}