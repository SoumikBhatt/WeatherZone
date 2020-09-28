package com.soumik.weatherzone.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.soumik.weatherzone.data.models.Cities
import com.soumik.weatherzone.data.models.CityUpdate


/**
 * Created by Soumik Bhattacharjee on 9/16/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */

@Dao
interface CityDao {

    @Query("SELECT * FROM city_bd WHERE name LIKE :key || '%'")
    suspend fun searchCity(key:String):List<Cities>

    @Update(entity = Cities::class)
    suspend fun updateSavedCity(vararg obj:CityUpdate):Int

    @Query("SELECT * FROM city_bd WHERE isSaved= :key")
    fun getSavedCity(key:Int):LiveData<List<Cities>>

    @Delete
    suspend fun deleteSavedCity(city:Cities)
}