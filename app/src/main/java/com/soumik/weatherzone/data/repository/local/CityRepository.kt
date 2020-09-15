package com.soumik.weatherzone.data.repository.local

import com.soumik.weatherzone.db.CityDatabase


/**
 * Created by Soumik Bhattacharjee on 9/16/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */
class CityRepository (private val database: CityDatabase) {

    suspend fun searchCities(key:String) = database.getCityDao().searchCity(key)
}