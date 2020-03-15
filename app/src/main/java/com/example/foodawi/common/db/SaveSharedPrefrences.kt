package com.example.foodawi.common.db

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.preference.PreferenceManager
import com.homyapplication.common.Constants
import java.util.*

object SaveSharedPreference {
   //  const val PREF_USER_LANGUAGE = "language"
    fun getSharedPreferences(ctx: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(ctx)
    }
    fun setLanguage(ctx: Context, lang: String) {
        val editor = getSharedPreferences(ctx).edit()
        editor.putString(Constants.KEY_LANGUAGE, lang)
        editor.apply()
    }

    // Localization
    fun setLocale(mContext: Context) {
        val locale = Locale(getLanguage(mContext))
        val configuration = Configuration()
        configuration.setLocale(locale)
        mContext.resources.updateConfiguration(configuration, mContext.resources.displayMetrics)
    }

    // Localization
    fun saveToken(mContext: Context,token:String) {
        val editor = getSharedPreferences(mContext).edit()
        editor.putString(Constants.FIREBASE_TOKEN, token)
        editor.apply()
    }
    // Localization
    fun getToken(mContext: Context):String? {
        return getSharedPreferences(mContext).getString(Constants.FIREBASE_TOKEN, "")

    }
    fun getLanguage(ctx: Context): String? {
        return getSharedPreferences(ctx).getString(Constants.KEY_LANGUAGE, Locale.getDefault().language)
    }
//    fun clearLanguage(ctx: Context) {
//        val editor = getSharedPreferences(ctx).edit()
//        editor.putString(PREF_USER_LANGUAGE, Locale.getDefault().language)
//        editor.apply()
//    }
}