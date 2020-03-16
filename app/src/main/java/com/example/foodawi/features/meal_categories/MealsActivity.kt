package com.example.foodawi.features.meal_categories

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.foodawi.R
import com.example.foodawi.common.Constants
import com.example.foodawi.common.Navigation
import com.example.foodawi.common.model.categories.mealsResponse.Meal
import com.example.foodawi.features.meal_categories.adapter.MealsAdapter
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.loading_animation.*
import org.koin.android.viewmodel.ext.android.viewModel

class MealsActivity : AppCompatActivity(R.layout.activity_details), MealsAdapter.Interaction {
    private val mealViewModel: MealsActivityViewModel by viewModel()
    lateinit var mealsAdapter: MealsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initRecycler()
        loading.start()
        val extras = intent.extras
        extras?.let {
            val dataRecieved = it.getString(Constants.CATEGORY_NAME)
            dataRecieved?.let {
                Log.i(javaClass.simpleName, it)
                mealViewModel.getMealsOfCategories(it)
            }
        }

        mealViewModel.mealCategories.observe(this, Observer {
            Log.i(javaClass.simpleName, it.meals.toString())
            mealsAdapter.submitList(it.meals)
            loading.stop()
        })
        mealViewModel.ErrorMessage.observe(this, Observer {
            Log.i(javaClass.simpleName, it)
            loading.stop()
        })
    }

    private fun initRecycler() {
        rv_meals.apply {
            mealsAdapter = MealsAdapter(this@MealsActivity)
            adapter = mealsAdapter
        }
    }

    override fun onItemSelected(position: Int, item: Meal) {
        Log.i(javaClass.simpleName, item.strMeal)
        Navigation.goToDetailActivity(this,item.idMeal)
    }
}
