package com.soumik.weatherzone.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity


/**
 * Created by Soumik Bhattacharjee on 9/17/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */
@Entity
data class CityUpdate (
    @ColumnInfo(name = "id")
    var id:Int?=null,

    @ColumnInfo(name = "isSaved")
    var isSaved:Int?=null
)