package com.arcode.eamovies.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arcode.eamovies.data.database.model.LocationEntity
import com.arcode.eamovies.utils.constants.Constants

@Dao
interface LocationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLocation(location: LocationEntity)

    @Query("SELECT * FROM ${Constants.TABLE_NAME_LOCATION}")
    suspend fun getAllLocation(): List<LocationEntity>

    @Query("DELETE FROM ${Constants.TABLE_NAME_LOCATION}")
    suspend fun deleteAllLocation()

}