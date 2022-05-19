package com.arcode.eamovies.data.database

import androidx.room.*
import com.arcode.eamovies.data.database.model.MovieEntity
import com.arcode.eamovies.utils.constants.Constants.TABLE_NAME_MOVIES

@Dao
interface DatabaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTopRatedMovie(movie: List<MovieEntity>)

    @Query("SELECT * FROM $TABLE_NAME_MOVIES")
    suspend fun getAllTopRatedMovies(): List<MovieEntity>

    @Delete
    suspend fun deleteTopRatedMovie(movie: MovieEntity)

    @Query("DELETE FROM $TABLE_NAME_MOVIES")
    suspend fun deleteAllTopRatedMovies()
}