package com.example.foodawi.features.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodawi.common.bases.launchDataLoad
import com.example.foodawi.common.model.categories.CategoriesResponse
import com.example.foodawi.common.model.categories.mealsResponse.MealsResponse
import com.example.foodawi.common.repositories.MainRepo.IMain

class MealsActivityViewModel(val mainRepo: IMain) : ViewModel() {

    private val _ErrorMessage = MutableLiveData<String>()
    val ErrorMessage: LiveData<String>
        get() = _ErrorMessage

    private val _mealCategories = MutableLiveData<MealsResponse>()
    val mealCategories: LiveData<MealsResponse>
        get() = _mealCategories

    fun getMealsOfCategories(category: String) {
        launchDataLoad(execution = {
            _mealCategories.postValue(mainRepo.getMeals(category))
        }, errorReturned = {
            _ErrorMessage.value = it.message
        })
    }
}