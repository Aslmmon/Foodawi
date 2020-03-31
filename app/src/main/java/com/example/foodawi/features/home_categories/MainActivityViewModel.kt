package com.example.foodawi.features.home_categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodawi.common.bases.launchDataLoad
import com.example.foodawi.common.model.categories.CategoriesResponse
import com.example.foodawi.common.repositories.MainRepo.IMain


enum class RequestStatus{LOADING,DONE,ERROR}
class MainActivityViewModel(val mainRepo: IMain) : ViewModel() {

    private val _ErrorMessage = MutableLiveData<String>()
    val ErrorMessage: LiveData<String>
        get() = _ErrorMessage


    private val _categoriesResponse = MutableLiveData<CategoriesResponse>()
    val CategoriesResponse: LiveData<CategoriesResponse>
        get() = _categoriesResponse

    fun getCategories() {
        launchDataLoad(execution = {
            _categoriesResponse.postValue(mainRepo.getMainCategories())
        }, errorReturned = {

            _ErrorMessage.value = it.message
        })
    }
}