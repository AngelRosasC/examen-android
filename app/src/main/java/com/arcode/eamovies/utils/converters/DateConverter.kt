package com.arcode.eamovies.utils.converters

import androidx.room.TypeConverter
import java.util.*

open class DateConverter {

    @TypeConverter
    fun fromTimestamp(value: Long): Date {
        return Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}