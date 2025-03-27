package com.gonzapolleria.promosapp.shared.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.gonzapolleria.promosapp.shared.room.entities.ConfigEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ConfigDao {
    @Query("SELECT * FROM config")
    fun getConfigsFlow(): Flow<List<ConfigEntity>>

    @Query("SELECT * FROM config")
    suspend fun getConfigsSuspend(): List<ConfigEntity>?

    @Query("SELECT * FROM config LIMIT 1")
    suspend fun getFirstConfig(): ConfigEntity?

    @Insert
    suspend fun insert(config: ConfigEntity)

    @Update
    suspend fun update(config: ConfigEntity)

    @Query("DELETE FROM config")
    suspend fun deleteConfig()
}