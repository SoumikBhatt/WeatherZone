package com.soumik.weatherzone.data.repository

import com.soumik.weatherzone.data.models.LocationData
import com.soumik.weatherzone.utils.RequestCompleteListener


/**
 * Created by Soumik Bhattacharjee on 9/11/2020.
 * soumikcse07@gmail.com,http://soumikbhatt.github.io/
 */
interface LocationProviderInterface {
    fun getUserCurrentLocation(callback:RequestCompleteListener<LocationData>)
}