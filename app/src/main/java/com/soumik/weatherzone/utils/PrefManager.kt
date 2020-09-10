package com.soumik.weatherzone.utils

import android.content.Context
import android.content.SharedPreferences


/**
 * Created by Soumik Bhattacharjee on 9/11/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */
class PrefManager(context: Context) {
    var preference: SharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)
    var editor: SharedPreferences.Editor = preference.edit()

    var tempUnit:String get() = preference.getString(KEY_UNITS,"metric")!!
    set(value) {editor.putString(KEY_UNITS,value).commit()}

}