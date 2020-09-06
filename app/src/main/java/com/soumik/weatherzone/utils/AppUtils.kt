package com.soumik.weatherzone.utils

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import com.soumik.weatherzone.BuildConfig


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