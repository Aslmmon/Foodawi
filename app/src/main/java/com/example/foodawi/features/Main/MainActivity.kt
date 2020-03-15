package com.example.foodawi.features.Main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.foodawi.R
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val mainViewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel.getCategories()
        mainViewModel.CategoriesResponse.observe(this, Observer {
            Log.i(javaClass.simpleName, it.toString())
        })
        mainViewModel.ErrorMessage.observe(this, Observer {
            Log.i(javaClass.simpleName, it.toString())
        })
    }
}
