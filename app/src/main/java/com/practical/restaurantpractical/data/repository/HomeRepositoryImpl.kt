package com.practical.restaurantpractical.data.repository

import com.practical.restaurantpractical.data.datasource.local.MyDao
import com.practical.restaurantpractical.data.datasource.remote.ApiService
import com.practical.restaurantpractical.domain.repository.HomeRepository
import com.practical.restaurantpractical.domain.model.RestaurantData
import com.practical.restaurantpractical.domain.model.Result
import com.practical.restaurantpractical.mapping.Mapping.toRestaurantData
import com.practical.restaurantpractical.mapping.Mapping.toResult
import com.practical.restaurantpractical.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val myDao: MyDao,
) : HomeRepository {

    override suspend fun getHomeData(noOfRecord: Int): Flow<Resource<RestaurantData?>> = flow {
        emit(Resource.Loading())

        val remoteData = try {
            apiService.getHomeData(total_record = noOfRecord)
        } catch (e: HttpException) {
            emit(Resource.Error(message = "An unexpected error occurred"))
            null
        } catch (e: IOException) {
            emit(Resource.Error(message = "Couldn't reach server. Check your internet connection"))
            null
        }

        remoteData?.let { data ->
            myDao.clearData()
            myDao.insertData(data.Result?.map { it?.toResult() })
            emit(Resource.Success(data = data.toRestaurantData()))
        }
    }

    override suspend fun searchData(searchText: String): Flow<Resource<List<Result>?>> = flow {
        emit(Resource.Loading())
        val data = myDao.searchData(searchText)
        data?.let {
            emit(Resource.Success(data = data))
        }
    }


}
