package com.practical.restaurantpractical.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.practical.restaurantpractical.domain.model.Result

@Dao
interface MyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(data: List<Result?>?)

    @Query("SELECT * FROM ResultTable WHERE slug LIKE :keyLater || '%'")
    suspend fun searchData(keyLater: String): List<Result>?


    @Query("delete from ResultTable")
    suspend fun clearData()


}