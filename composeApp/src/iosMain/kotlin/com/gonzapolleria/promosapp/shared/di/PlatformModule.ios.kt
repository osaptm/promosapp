package com.gonzapolleria.promosapp.shared.di

import org.koin.core.module.Module
import org.koin.dsl.module
import com.gonzapolleria.promosapp.shared.room.getDatabaseBuilder
import com.gonzapolleria.promosapp.shared.room.getAppDatabase
import com.gonzapolleria.promosapp.shared.room.AppDatabase

actual fun platformModule(): Module = module {
    single<AppDatabase> {
        val builder = getDatabaseBuilder()
        getAppDatabase(builder)
    }
}