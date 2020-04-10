package com.example.foodawi.features.home_categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodawi.common.bases.BaseViewModel
import com.example.foodawi.common.bases.ResponseWrapper
import com.example.foodawi.common.model.categories.CategoriesResponse
import com.example.foodawi.common.repositories.MainRepo.IMain
import kotlinx.coroutines.launch


@Suppress("UNCHECKED_CAST")
class MainActivityViewModel(val mainRepo: IMain) : BaseViewModel() {


    private val _categoriesResponse = MutableLiveData<CategoriesResponse>()
    val CategoriesResponse: LiveData<CategoriesResponse>
        get() = _categoriesResponse

    fun getCategories():ResponseWrapper<CategoriesResponse>{
       return showData({ mainRepo.getMainCategories() },_categoriesResponse) as ResponseWrapper<CategoriesResponse>
    }
}