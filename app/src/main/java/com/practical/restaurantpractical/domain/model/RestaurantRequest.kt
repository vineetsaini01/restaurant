package com.practical.restaurantpractical.domain.model

// RestaurantRequest.kt
data class RestaurantRequest(
    val date: String = "",
    val cityname: String = "Ahmedabad",
    val latitude: Double = 23.0895229,
    val cuisine_id: String = "",
    val skip: Int = 0,
    val starttime: String = "",
    val Is_langauge: String = "en",
    val sort_type: Int = 0,
    val user_id: String = "",
    val filter_type: String = "",
    val cost_range: String = "",
    val vendor_id: Int = 40818,
    val state: String = "GJ",
    val delivery_type_time_slots: Int = 1,
    val longitude: Double = 72.5326884,
    var total_record: Int = 7
)
