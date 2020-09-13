package com.soumik.weatherzone.network

import com.soumik.weatherzone.data.models.ResponseWeather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Soumik Bhattacharjee on 9/11/2020.
 * soumikcse07@gmail.com,http://soumikbhatt.github.io/
 */
interface ApiInterface {

    @GET("weather")
   suspend fun getWeatherByLocation(
        @Query("lat")
        latitude:String,
        @Query("lon")
        longitude:String,
    ):Response<ResponseWeather>

    @GET("weather")
    suspend fun getWeatherByQuery(
        @Query("q")
        query:String
    ):Response<ResponseWeather>
}