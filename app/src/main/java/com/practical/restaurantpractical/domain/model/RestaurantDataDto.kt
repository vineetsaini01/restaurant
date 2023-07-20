package com.practical.restaurantpractical.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class RestaurantData(
    var Result: List<Result?>?,
    val code: Int?,
    val msg: String?,
    val open_restaurant: Int?
)

@Entity(tableName = "ResultTable")
data class Result(
    val restaurant_id: Int?,
    //val cuisine_name: List<String?>?,
    val delivery_time: String?,
    val icon_image: String?,
    val name: String?,
    val rating: Double?,
    @PrimaryKey
    val slug: String,
    val two_person_price: String?
)

