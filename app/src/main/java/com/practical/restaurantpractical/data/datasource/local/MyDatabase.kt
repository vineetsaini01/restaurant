package com.practical.restaurantpractical.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.practical.restaurantpractical.domain.model.Result

@Database(
    entities = [Result::class],
    version = 1,
    exportSchema = true
)
abstract class MyDatabase : RoomDatabase() {
    abstract val myDao: MyDao
}