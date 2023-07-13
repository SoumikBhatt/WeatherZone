package com.soumik.weatherzone.data.repository.local

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.soumik.weatherzone.data.models.LocationData
import com.soumik.weatherzone.utils.RequestCompleteListener

/**
 * Created by Soumik Bhattacharjee on 9/11/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */
class LocationProvider(context: Context): LocationProviderInterface {

    private var fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

    private  var callbacks :RequestCompleteListener<LocationData>?=null
    @SuppressLint("MissingPermission")
    override fun getUserCurrentLocation(callback: RequestCompleteListener<LocationData>) {
        fusedLocationClient.lastLocation.addOnSuccessListener {
            callbacks = callback
            it?.also { callback.onRequestCompleted(setLocationData(it)) }
        } .addOnFailureListener {
            callback.onRequestFailed(it.localizedMessage)
        }


        startLocationUpdates()
    }

    private val locationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            if(locationResult.locations.isEmpty()) return
            callbacks?.onRequestCompleted(setLocationData(locationResult.locations[0]))
        }
    }

    @SuppressLint("MissingPermission")
    private fun startLocationUpdates() {
        fusedLocationClient.requestLocationUpdates(
            locationRequest,
            locationCallback,
            null
        )
    }

    private fun setLocationData(location: Location):LocationData {
        return LocationData(longitude = location.longitude, latitude = location.latitude)
    }

    companion object {
        val locationRequest = LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 10000)
            .setWaitForAccurateLocation(false)
            .setMinUpdateIntervalMillis(5000)
            .setMaxUpdateDelayMillis(10000)
            .build()
    }
}