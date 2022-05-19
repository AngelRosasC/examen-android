package com.arcode.eamovies.di

import android.content.Context
import androidx.annotation.NonNull
import androidx.room.Room
import com.arcode.eamovies.data.database.DatabaseApp
import com.arcode.eamovies.data.database.dao.DatabaseDao
import com.arcode.eamovies.utils.constants.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @NonNull
    @Provides
    @Singleton
    fun provideDatabaseApp(@ApplicationContext context: Context): DatabaseApp =
        Room.databaseBuilder(context, DatabaseApp::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()


    @NonNull
    @Provides
    @Singleton
    fun provideDatabaseDao(@ApplicationContext context: Context): DatabaseDao =
        provideDatabaseApp(context).dao()
}