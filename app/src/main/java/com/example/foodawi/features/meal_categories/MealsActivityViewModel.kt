package com.example.foodawi.features.meal_categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodawi.common.bases.BaseViewModel
import com.example.foodawi.common.bases.ResponseWrapper
import com.example.foodawi.common.model.categories.mealsResponse.MealsResponse
import com.example.foodawi.common.repositories.MainRepo.IMain

class MealsActivityViewModel(val mainRepo: IMain) : BaseViewModel() {


    private val _mealCategories = MutableLiveData<MealsResponse>()
    val mealCategories: LiveData<MealsResponse>
        get() = _mealCategories

    fun getMealsOfCategories(category: String): ResponseWrapper<MealsResponse> {
        return showData(
            { mainRepo.getMeals(category = category) },
            _mealCategories
        ) as ResponseWrapper<MealsResponse>
//        launchDataLoad(execution = {
//            _mealCategories.postValue(mainRepo.getMeals(category))
//        }, errorReturned = {
//            _ErrorMessage.value = it.message
//        })
    }
}