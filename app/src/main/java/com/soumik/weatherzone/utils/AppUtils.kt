package com.soumik.weatherzone.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import com.soumik.utilslibrary.Utills
import com.soumik.weatherzone.BuildConfig
import com.soumik.weatherzone.R
import com.soumik.weatherzone.ui.base.WeatherZone
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by Soumik Bhattacharjee on 9/5/2020.
 * soumikcse07@gmail.com
 */

fun debug(tag:String,message:String) {
    if (BuildConfig.DEBUG) Log.d(tag,message)
}
fun error(tag:String,message:String) {
    if (BuildConfig.DEBUG) Log.e(tag,message)
}
fun info(tag:String,message:String) {
    if (BuildConfig.DEBUG) Log.i(tag,message)
}

fun lightStatusBar(activity:Activity,value:Boolean){
    if (value){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            activity.window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }
}

fun showToast(context:Context,message:String,length:Int) {
    Toast.makeText(context,message,length).show()
}

fun isNetworkActive(context: Context):Boolean{
    val isConnected:Boolean
    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = cm.activeNetworkInfo

    isConnected = activeNetwork !=null
    return isConnected
}

fun Int.unixTimestampToDateTimeString() : String {

    try {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = this*1000.toLong()

        val outputDateFormat = SimpleDateFormat("dd MMM, yyyy - hh:mm a", Locale.ENGLISH)
        outputDateFormat.timeZone = TimeZone.getDefault() // user's default time zone
        return outputDateFormat.format(calendar.time)

    } catch (e: Exception) {
        e.printStackTrace()
    }

    return this.toString()
}

fun Int.unixTimestampToTimeString() : String {

    try {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = this*1000.toLong()

        val outputDateFormat = SimpleDateFormat("hh:mm a", Locale.ENGLISH)
        outputDateFormat.timeZone = TimeZone.getDefault()
        return outputDateFormat.format(calendar.time)

    } catch (e: Exception) {
        e.printStackTrace()
    }

    return this.toString()
}

fun showMoreOptions(context: Context) {
    val dialog = Dialog(context)
    dialog.requestWindowFeature(Window.FEATURE_OPTIONS_PANEL)
    val window = dialog.window
    val wlp = window?.attributes
    wlp?.gravity = Gravity.TOP or Gravity.END
    wlp?.width = WindowManager.LayoutParams.MATCH_PARENT
    wlp?.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND
    wlp?.x = 20
    wlp?.y = 120
    window?.attributes = wlp
    dialog.setCancelable(true)
    dialog.setContentView(R.layout.dialog_more)

    val share = dialog.findViewById<TextView>(R.id.tv_share)
    val feedback = dialog.findViewById<TextView>(R.id.tv_feedback)

    val storeLink = "https://play.google.com/store/apps/details?id=${context.packageName}"
    share.setOnClickListener {
        Utills.share(context,context.getString(R.string.app_name),"Hey! You must try this amazing Weather Zone App: $storeLink","Share Now Via")
        dialog.dismiss()
    }
    feedback.setOnClickListener {
        Utills.feedback(context,context.getString(R.string.app_email),
            "Feedback for ${context.getString(R.string.app_name)} v${BuildConfig.VERSION_NAME}",
            "\n\n\n\n---Don't remove this part (These information will make our life easier)---\nManufacturer: ${Build.MANUFACTURER}\nModel: ${Build.MODEL}\nAndroid Version: ${Build.VERSION.SDK_INT}")
        dialog.dismiss()
    }

    dialog.show()
}