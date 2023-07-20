package com.practical.restaurantpractical.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey


data class RestaurantDataDto(
    val Result: List<ResultDto?>?,
    val code: Int?,
    val msg: String?,
    val open_restaurant: Int?
)

data class RestaurantTagDto(
    val background_color: String?,
    val id: Int?,
    val name: String?,
    val secondary_name: String?,
    val text_color: String?
)

data class ResultDto(
    val app_detail_layout: String?,
    val cuisine_name: List<String?>?,
    val delivery_time: String?,
    val delivery_times: String?,
    val discount_text: String?,
    val distance: Double?,
    val franchisee_id: Int?,
    val icon_image: String?,
    val item_counts: Int?,
    val menu_category_count: Int?,
    val name: String?,
    val rating: Double?,
    val restaurant_convince_charge: Int?,
    val restaurant_convince_type: String?,
    val restaurant_id: Int?,
    val restaurant_on_off: String?,
    val restaurant_packaging_charge: String?,
    val restaurant_packaging_type: String?,
    val restaurant_service_tax: Int?,
    val restaurant_tags: List<RestaurantTagDto?>?,
    val review_count: Int?,
    val slug: String?,
    val two_person_price: String?
)