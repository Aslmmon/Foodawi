package com.example.foodawi.common.bases

import android.annotation.SuppressLint
import android.app.Activity
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.CountDownTimer
import android.text.Editable
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.material.snackbar.Snackbar
import com.google.gson.GsonBuilder

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import retrofit2.HttpException

import java.net.SocketTimeoutException
import java.net.UnknownHostException

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
//
//fun Throwable?.toErrorBody(): String {
//    val s = when (this) {
//        is SocketTimeoutException -> " Check Your Network Connection , Try Again later "
//        is ConnectException -> " Check Your Network Connection , Try Again later "
//        is UnknownHostException -> message.toString() + " Try again later "
//        is HttpException -> {
//            val errorBodyResponse = response()?.errorBody()?.string()
//            val gson = GsonBuilder().create()
//            val error = gson.fromJson<ErrorResponse>(errorBodyResponse, ErrorResponse::class.java)
//            when (error.httpCode) {
//                422 -> {
//                    val mobileError = error.error.message.mobile?.get(0)
//                    val passwordError = error.error.message.password?.get(0)
//                    var nameError = error.error.message.name?.get(0)
//                    var emailError = error.error.message.email?.get(0)
//                    nameError?.let { nameError -> return nameError }
//                    mobileError?.let { mobileError -> return mobileError }
//                    passwordError?.let { passwordError -> return passwordError }
//                    emailError?.let { email -> return email }
//                }
//                400 -> {
//                    val bodyError = error.error.message.body?.get(0)
//                    return bodyError.toString()
//                }
//                401 -> {
//                    // unAuthenticated
//                    val bodyError = error.error.message.body?.get(0)
//                    return bodyError.toString()
//                }
//                403 -> {
//                    // unAuthroized
//                    val bodyError = error.error.message.body?.get(0)
//                    return bodyError.toString()
//
//                }
//                else -> message()
//            }
//        }
//        else -> this?.message
//    }
//    return this?.message.toString()
//}
//
//fun SharedPreferences.Editor.saveUser(result: User) {
//    val name = result.name
//    val token = result.token
//    val email = result.email
//    val mobile = result.mobile
//    val gson = GsonBuilder().create()
//    val json = gson.toJson(User(name, mobile, email, token))
//    putString(Constants.USER_DATA, json).apply()
//}
//
//inline fun <reified T> SharedPreferences.Editor.jsonToClass(@RawRes resourceId: Int): T =
//        Gson().fromJson(resources.openRawResource(resourceId).bufferedReader().use { it.readText() }, T::class.java)

//fun SharedPreferences.getUser(): User? {
//    val gson = GsonBuilder().create()
//    val json = this.getString(Constants.USER_DATA, "")
//    val user = gson.fromJson<User>(json, User::class.java)
//    return user
//
//}

fun ViewModel.launchDataLoad(
    execution: suspend CoroutineScope.() -> Unit,
    errorReturned: suspend CoroutineScope.(Throwable) -> Unit,
    finallyBlock: (suspend CoroutineScope.() -> Unit)? = null
) {

    this.viewModelScope.launch {
        try {
            execution()
        } catch (e: Throwable) {
            errorReturned(e)
        } finally {
            finallyBlock?.invoke(this)
        }
    }
}


//val Editable.checkIfZeroValueEnterd: Boolean
//    get() {
//        val txtInInteger = this.toString().toInt()
//        if (txtInInteger == 0) {
//            return true
//        }
//        return false
//    }
//
//fun Context.showSnack(view: View?, message: String) {
//    view?.let { viewSnack->
//        val snack = Snackbar.make(viewSnack, message, Snackbar.LENGTH_SHORT)
//        snack.setActionTextColor(Color.RED)
//        snack.show()
//    }
//
//
//}
//
//fun Context.showCaseOfViews(ctx: Context, view: View, ivMainActivityMenu: View) {
//    val config = ShowcaseConfig()
//    config.delay = 500 // half second between each showcase view
//    val sequence = MaterialShowcaseSequence(ctx as Activity, Constants.SHOW_CASE_SEQUENCE)
//    sequence.setConfig(config)
//    sequence.addSequenceItem(view, resources.getString(R.string.notification_text_show_case), resources.getString(R.string.dismiss_text_show_case))
//    sequence.addSequenceItem(ivMainActivityMenu, resources.getString(R.string.notification_text_show_case), resources.getString(R.string.dismiss_text_show_case))
////    sequence.addSequenceItem(
////            MaterialShowcaseView.Builder(ctx)
////                    .setSkipText("SKIP")
////                    .setTarget(ivMainActivityMenu)
////                    .setDismissText("GOT IT")
////                    .setContentText("This is Menu Item , to Get All ")
////                    .build()
////    )
//    sequence.start()
//}
//
//fun Context.showStoppableTimer(millisInFuture: Long, countDownInterval: Long, isPaused: Boolean,
//                               isCancelled: Boolean, view: TextView, resumFromMillis: Long): CountDownTimer {
//
//    return object : CountDownTimer(millisInFuture, countDownInterval) {
//        @SuppressLint("SetTextI18n")
//        override fun onTick(millisUntilFinished: Long) {
//            val timeRemaining = "Time : ${millisUntilFinished / 1000}"
//
//            if (isPaused) {
//                view.text = "${view.text}\nPaused"
//                var resumeFromMillis = millisUntilFinished
//                cancel()
//            } else if (isCancelled) {
//                view.text = "${view.text}\nStopped.(Cancelled)"
//                cancel()
//            } else {
//                view.text = timeRemaining
//            }
//        }
//
//        override fun onFinish() {
//            view.text = "Done"
//        }
//    }
//
//
//}
//
//
//fun View.setSafeOnClickListener(onSafeClick: (View) -> Unit) {
//    val safeClickListener = SafeClickListener {
//        onSafeClick(it)
//    }
//    setOnClickListener(safeClickListener)
//}
//
//
//fun NotificationManager.sendNotification(messageBody: String, messageTitle: String, applicationContext: Context) {
//    val contentIntent = Intent(applicationContext, OrdersHistoryActivity::class.java)
//    contentIntent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
//    contentIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
//    val pendingIntent = PendingIntent.getActivity(
//            applicationContext, 5, contentIntent,
//            PendingIntent.FLAG_UPDATE_CURRENT
//    )
//
//    val builder = NotificationCompat.Builder(
//            applicationContext,
//            applicationContext.getString(R.string.notification_id)
//    ).setContentTitle((messageTitle))
//            .setContentText(messageBody)
//            .setContentIntent(pendingIntent)
//            .setLargeIcon(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.ic_logo))
//            .setSmallIcon(R.drawable.ic_logo)
//            .setAutoCancel(true)
//            .setPriority(NotificationCompat.PRIORITY_HIGH)
//
//    notify(5, builder.build())
//}

fun NotificationManager.cancelAllNotifications() {
    cancelAll()
}

fun NotificationManager.cancelSpecificNotifcation(id: Int) {
    cancel(id)
}




