package com.example.foodawi.features.home_categories

import com.example.foodawi.Base.BaseTest
import com.example.foodawi.common.repositories.MainRepo.IMain
import com.example.foodawi.common.repositories.MainRepo.MainRepo
import kotlinx.coroutines.runBlocking
import org.hamcrest.Matchers.`is`
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class MainActivityViewModelTest : BaseTest() {
    private lateinit var mainActivityViewModel: MainActivityViewModel

    @Mock
    lateinit var main: MainRepo

    override fun provideInitialSetup() {
        mainActivityViewModel = MainActivityViewModel(main)
    }

    @Test
    fun callingGetCategoriesMethod_whenCalled_shouldgetData() {
        mainActivityViewModel.getCategories()
        runBlocking { verify(main, times(1)).getMainCategories() }
    }
}