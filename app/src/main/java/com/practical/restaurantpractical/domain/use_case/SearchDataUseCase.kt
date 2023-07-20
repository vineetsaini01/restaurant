package com.practical.restaurantpractical.domain.use_case

import com.practical.restaurantpractical.domain.repository.HomeRepository
import javax.inject.Inject

class SearchDataUseCase @Inject constructor(private val homeRepository: HomeRepository) {

    suspend operator fun invoke(searchText: String) =
        homeRepository.searchData(searchText = searchText)

}