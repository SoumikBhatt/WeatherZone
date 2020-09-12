package com.soumik.weatherzone.data.repository.remote

import com.soumik.weatherzone.network.RetrofitClient


/**
 * Created by Soumik Bhattacharjee on 9/13/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */
class WeatherRepository {

    suspend fun getWeatherByLocation(lat:String,lon:String) = RetrofitClient.api.getWeatherByLocation(lat,lon)
}