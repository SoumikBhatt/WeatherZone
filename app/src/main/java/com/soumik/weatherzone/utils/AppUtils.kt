package com.soumik.weatherzone.utils

import android.util.Log
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