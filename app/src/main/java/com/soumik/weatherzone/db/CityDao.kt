package com.soumik.weatherzone.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.soumik.weatherzone.data.models.Cities


/**
 * Created by Soumik Bhattacharjee on 9/16/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */

@Dao
interface CityDao {

    @Query("SELECT * FROM city_bd WHERE name LIKE :key || '%'")
    suspend fun searchCity(key:String):List<Cities>
}