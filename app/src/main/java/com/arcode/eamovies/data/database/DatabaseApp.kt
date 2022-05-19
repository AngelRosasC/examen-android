package com.arcode.eamovies.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.arcode.eamovies.data.database.model.MovieEntity
import com.arcode.eamovies.utils.constants.Constants.DATABASE_VERSION
import com.arcode.eamovies.utils.converters.IntegerListConverter

@Database(entities = [MovieEntity::class], version = DATABASE_VERSION, exportSchema = false)
@TypeConverters(IntegerListConverter::class)
abstract class DatabaseApp : RoomDatabase() {
    abstract fun dao(): DatabaseDao
}