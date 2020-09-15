package com.soumik.weatherzone.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.soumik.weatherzone.data.models.Cities
import com.soumik.weatherzone.utils.DB_NAME


/**
 * Created by Soumik Bhattacharjee on 9/16/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */


@Database(
    entities =[Cities::class],
    version = 1
)
abstract class CityDatabase:RoomDatabase() {

    abstract fun getCityDao():CityDao

    companion object{

        @Volatile
        private var instance:CityDatabase?=null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK){
            instance?:createDatabase(context).also{ instance=it}
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(context.applicationContext,CityDatabase::class.java, DB_NAME).createFromAsset(DB_NAME).build()
    }
}