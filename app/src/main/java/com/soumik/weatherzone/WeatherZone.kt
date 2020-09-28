package com.soumik.weatherzone

import android.app.Application
import android.content.Context


/**
 * Created by Soumik Bhattacharjee on 9/11/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */
class WeatherZone:Application() {
    companion object{
         lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context =applicationContext
    }
}