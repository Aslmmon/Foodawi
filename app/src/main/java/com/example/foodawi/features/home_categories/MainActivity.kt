package com.example.foodawi.features.home_categories

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.foodawi.R
import com.example.foodawi.common.Navigation
import com.example.foodawi.common.model.categories.Category
import com.example.foodawi.features.home_categories.adapter.CategoriesAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.loading_animation.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main), CategoriesAdapter.Interaction {

    private val mainViewModel: MainActivityViewModel by viewModel()
    lateinit var mainCategoriesADapter: CategoriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Home"
        supportActionBar?.title = "bye"
        titleColor = Color.RED

        initRecycler()
        mainViewModel.getCategories()
        startLoading()
        mainViewModel.CategoriesResponse.observe(this, Observer {
            Log.i(javaClass.simpleName, it.toString())
            stopLoading()
            mainCategoriesADapter.submitList(it.categories)
        })
        mainViewModel.ErrorMessage.observe(this, Observer {
            Log.i(javaClass.simpleName, it.toString())
            stopLoading()
        })
    }

    private fun startLoading() {
        loading.start()
    }

    private fun stopLoading() {
        loading.stop()
    }

    private fun initRecycler() {
        recycler_food_categories.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            mainCategoriesADapter = CategoriesAdapter(this@MainActivity)
            adapter = mainCategoriesADapter
        }
    }

    override fun onItemSelected(position: Int, item: Category) {
        Log.i(javaClass.simpleName, "clicked on ${item.strCategory}")
        Navigation.goToDetailsActivity(this, item.strCategory)
    }
}
