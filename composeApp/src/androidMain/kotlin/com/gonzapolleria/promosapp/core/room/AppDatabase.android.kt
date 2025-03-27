package com.gonzapolleria.promosapp.core.room


import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gonzapolleria.promosapp.core.room.AppDatabase
import com.gonzapolleria.promosapp.core.room.DATABASE_NAME

fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<AppDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath(DATABASE_NAME)

    return Room.databaseBuilder<AppDatabase>(
        context = appContext,
        name = dbFile.absolutePath,
    )
}