package com.practical.restaurantpractical.mapping

import com.practical.restaurantpractical.data.dto.RestaurantDataDto
import com.practical.restaurantpractical.data.dto.ResultDto
import com.practical.restaurantpractical.domain.model.RestaurantData
import com.practical.restaurantpractical.domain.model.Result

object Mapping {

    fun RestaurantDataDto.toRestaurantData(): RestaurantData {

        return RestaurantData(
            code = code,
            open_restaurant = open_restaurant,
            msg = msg,
            Result = Result?.map { it?.toResult() }
        )
    }

    fun ResultDto.toResult(): Result {
        return Result(
            name = name,
            //cuisine_name = cuisine_name,
            delivery_time = delivery_time,
            rating = rating,
            icon_image = icon_image,
            two_person_price = two_person_price,
            restaurant_id = restaurant_id,
            slug = slug!!
        )
    }

}