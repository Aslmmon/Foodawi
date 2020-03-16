package com.example.foodawi.features.details

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.foodawi.R
import com.example.foodawi.common.Constants
import org.koin.android.viewmodel.ext.android.viewModel

class MealsActivity : AppCompatActivity(R.layout.activity_details) {
    private val mealViewModel: MealsActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val extras = intent.extras
        extras?.let {
            val dataRecieved = it.getString(Constants.CATEGORY_NAME)
            dataRecieved?.let {
                Log.i(javaClass.simpleName, it)
                mealViewModel.getMealsOfCategories(it)
            }
        }

        mealViewModel.mealCategories.observe(this, Observer {
            Log.i(javaClass.simpleName,it.meals.toString())
        })
        mealViewModel.ErrorMessage.observe(this, Observer {
            Log.i(javaClass.simpleName,it)
        })
    }
}
