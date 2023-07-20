package com.practical.restaurantpractical.presentation.view_model


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practical.restaurantpractical.domain.model.RestaurantData
import com.practical.restaurantpractical.domain.use_case.GetHomeDataUseCase
import com.practical.restaurantpractical.domain.use_case.SearchDataUseCase
import com.practical.restaurantpractical.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeDataUseCase: GetHomeDataUseCase,
    private val searchDataUseCase: SearchDataUseCase,
) : ViewModel() {

    var homeResponseData by mutableStateOf<RestaurantData?>(null)
    var isLoading by mutableStateOf(false)
    var isMenuExpanded by mutableStateOf(false)
    var noOfRecord by mutableStateOf(7)
    var searchText by mutableStateOf("")


    init {
        getData()
    }

    fun onChanged(newValue: Int) {
        noOfRecord = newValue
        isMenuExpanded = false
        getData()
    }

    fun onChangedSearchText(newValue: String) {
        searchText = newValue
        searchData(newValue)
    }

    private fun getData() {
        val data = noOfRecord
        viewModelScope.launch(Dispatchers.IO) {
            getHomeDataUseCase(noOfRecord = data).onEach { resource ->
                when (resource) {
                    is Resource.Success -> {
                        homeResponseData = resource.data
                        isLoading = false
                    }

                    is Resource.Error -> {
                        homeResponseData = resource.data
                        isLoading = false
                    }

                    is Resource.Loading -> {
                        isLoading = true
                    }
                }
            }.launchIn(viewModelScope)
        }
    }

    private fun searchData(newValue: String) {
        viewModelScope.launch(Dispatchers.IO) {
            searchDataUseCase(searchText = newValue).onEach { resource ->
                when (resource) {
                    is Resource.Success -> {
                        homeResponseData?.Result = resource.data
                        isLoading = false
                    }

                    is Resource.Error -> {
                        isLoading = false
                    }

                    is Resource.Loading -> {
                        isLoading = true
                    }
                }
            }.launchIn(viewModelScope)
        }
    }


}