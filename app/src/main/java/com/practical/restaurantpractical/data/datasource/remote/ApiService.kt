package com.practical.restaurantpractical.data.datasource.remote

import com.practical.restaurantpractical.data.dto.RestaurantDataDto
import retrofit2.http.POST
import retrofit2.http.Query





interface ApiService {
    @POST("v1/get_nearby_restaurant")
    suspend fun getHomeData(
        @Query("date") date: String?=null,
        @Query("cityname") cityname: String?="Ahmedabad",
        @Query("latitude") latitude: Double=23.0895229,
        @Query("cuisine_id") cuisine_id: String?=null,
        @Query("skip") skip: Int=0,
        @Query("starttime") starttime: String?=null,
        @Query("Is_langauge") Is_langauge: String?="en",
        @Query("sort_type") sort_type: Int?=null,
        @Query("user_id") user_id: String?=null,
        @Query("filter_type") filter_type: String?=null,
        @Query("cost_range") cost_range: String?=null,
        @Query("vendor_id") vendor_id: Int=40818,
        @Query("state") state: String?="GJ",
        @Query("delivery_type_time_slots") delivery_type_time_slots: Int=1,
        @Query("longitude") longitude: Double=72.5326884,
        @Query("total_record") total_record: Int=7
    ):  RestaurantDataDto?
}
