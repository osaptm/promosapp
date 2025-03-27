package com.gonzapolleria.promosapp.core.di

import com.gonzapolleria.promosapp.core.room.getDatabaseBuilder
import com.gonzapolleria.promosapp.core.room.getAppDatabase
import com.gonzapolleria.promosapp.core.room.AppDatabase
import org.koin.core.module.Module
import org.koin.dsl.module


actual fun platformModule(): Module = module {
   single<AppDatabase> {
        val builder = getDatabaseBuilder(context = get())
       getAppDatabase(builder)
    }
}