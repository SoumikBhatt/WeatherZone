package com.soumik.weatherzone.models.repository

import com.soumik.weatherzone.models.dataClasses.LocationData
import com.soumik.weatherzone.utils.RequestCompleteListener


/**
 * Created by Soumik Bhattacharjee on 9/11/2020.
 * soumikcse07@gmail.com,http://soumikbhatt.github.io/
 */
interface LocationProviderInterface {
    fun getUserCurrentLocation(callback:RequestCompleteListener<LocationData>)
}