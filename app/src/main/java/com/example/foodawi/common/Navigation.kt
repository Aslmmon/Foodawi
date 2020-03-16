package com.example.foodawi.common

import android.content.Context
import android.content.Intent
import com.example.foodawi.features.details.MealsActivity

object Navigation {

    fun goToDetailsActivity(ctx: Context, name: String) {
        val intent = Intent(ctx, MealsActivity::class.java)
        intent.putExtra(Constants.CATEGORY_NAME, name)
        ctx.startActivity(intent)
    }
}