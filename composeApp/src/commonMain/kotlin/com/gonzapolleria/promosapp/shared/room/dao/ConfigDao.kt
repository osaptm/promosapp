package com.gonzapolleria.promosapp.shared.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.gonzapolleria.promosapp.shared.room.entities.ConfigEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ConfigDao {
    @Query("SELECT * FROM config")
    fun getConfigs(): Flow<List<ConfigEntity>>
}