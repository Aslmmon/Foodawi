package com.example.foodawi.features.search

import android.app.SearchManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodawi.R
import com.example.foodawi.common.bases.toast

class SearchableActivity : AppCompatActivity(R.layout.activity_searchable) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleIntent(intent)
    }
    override fun onNewIntent(intent: Intent) {
        handleIntent(intent)
        super.onNewIntent(intent)

    }
    private fun handleIntent(intent: Intent) {

        if (Intent.ACTION_SEARCH == intent.action) {
            val query = intent.getStringExtra(SearchManager.QUERY)
            //use the query to search your data somehow
        }
    }
}
