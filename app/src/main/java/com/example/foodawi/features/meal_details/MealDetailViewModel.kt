package com.example.foodawi.features.meal_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodawi.common.bases.launchDataLoad
import com.example.foodawi.common.model.categories.meal_details.MealDetailsResponse
import com.example.foodawi.common.repositories.mealDetailRepo.IMealDetail

class MealDetailViewModel(var detailsRepo: IMealDetail) : ViewModel() {

    private val _ErrorMessage = MutableLiveData<String>()
    val ErrorMessage: LiveData<String>
        get() = _ErrorMessage

    private val _detailsResponse = MutableLiveData<MealDetailsResponse>()
    val detailsResponse: LiveData<MealDetailsResponse>
        get() = _detailsResponse

    fun getMealDetails(mealID: String) {
        launchDataLoad(execution = {
            _detailsResponse.postValue(detailsRepo.getMealDetails(mealID))
        }, errorReturned = {
            _ErrorMessage.value = it.message
        })
    }
}