package com.soumik.weatherzone.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.soumik.weatherzone.models.dataClasses.LocationData
import com.soumik.weatherzone.models.repository.LocationProvider
import com.soumik.weatherzone.utils.RequestCompleteListener


/**
 * Created by Soumik Bhattacharjee on 9/11/2020.
 * soumikcse07@gmail.com,http://soumikbhatt.github.io/
 */
class MyViewModel:ViewModel() {

    //location live data
    val locationLiveData = MutableLiveData<LocationData>()
    val locationLiveDataFailure = MutableLiveData<String>()

    fun getCurrentLocation(model:LocationProvider){
        model.getUserCurrentLocation(object : RequestCompleteListener<LocationData>{
            override fun onRequestCompleted(data: LocationData) {
                locationLiveData.postValue(data)
            }

            override fun onRequestFailed(errorMessage: String?) {
                locationLiveDataFailure.postValue(errorMessage)
            }
        })
    }

}