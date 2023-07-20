package com.practical.restaurantpractical.domain.repository

import com.practical.restaurantpractical.domain.model.RestaurantData
import com.practical.restaurantpractical.domain.model.Result
import com.practical.restaurantpractical.utils.Resource
import kotlinx.coroutines.flow.Flow


interface HomeRepository {
    suspend fun getHomeData(noOfRecord: Int): Flow<Resource<RestaurantData?>>
    suspend fun searchData(searchText: String): Flow<Resource<List<Result>?>>
}