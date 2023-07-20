package com.practical.restaurantpractical.domain.use_case

import com.practical.restaurantpractical.domain.repository.HomeRepository
import javax.inject.Inject

class GetHomeDataUseCase @Inject constructor(private val homeRepository: HomeRepository) {

    suspend operator fun invoke(noOfRecord: Int) = homeRepository.getHomeData(noOfRecord=noOfRecord)

}