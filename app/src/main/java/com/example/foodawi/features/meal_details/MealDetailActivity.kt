package com.example.foodawi.features.meal_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.foodawi.R
import com.example.foodawi.common.Constants
import com.example.foodawi.common.model.categories.meal_details.Meal
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_meal_detail.*
import org.koin.android.viewmodel.ext.android.viewModel

class MealDetailActivity : AppCompatActivity(R.layout.activity_meal_detail) {
    private val detailMealViewModel: MealDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val extras = intent.extras
        extras?.let {
            val mealID = it.getString(Constants.MEAL_ID)
            mealID?.let {
                detailMealViewModel.getMealDetails(it)
            }

        }
        detailMealViewModel.detailsResponse.observe(this, Observer {
            Log.i(javaClass.simpleName, it.toString())
            bindDataToView(it.meals[0])
        })

        detailMealViewModel.ErrorMessage.observe(this, Observer {
            Log.i(javaClass.simpleName, it.toString())

        })
    }

    private fun bindDataToView(meal: Meal) {
        tv_meal_name.text = meal.strMeal
        tv_meal_description.text = meal.strInstructions
        val picasso = Picasso.get()
        picasso.load(meal.strMealThumb).into(iv_detail_meal)

    }


}
