package com.example.foodawi.features.home_categories

import android.app.SearchManager
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.foodawi.R
import com.example.foodawi.common.Navigation
import com.example.foodawi.common.bases.toast
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
        setSupportActionBar(app_bar)
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.home_menu, menu)

        // Get the SearchView and set the searchable configuration
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu?.findItem(R.id.search_icon)?.actionView as SearchView).apply {
            // Assumes current activity is the searchable activity
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
            isIconifiedByDefault = false // Do not iconify the widget; expand it by default
            isSubmitButtonEnabled = true
        }.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    toast(query)
                    return true
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    toast(newText)
                    return true
                }
                return false
            }

        })

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.search_icon -> {
                toast("search")
                onSearchRequested()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

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
        Navigation.goToMealActivity(this, item.strCategory)
    }
}
