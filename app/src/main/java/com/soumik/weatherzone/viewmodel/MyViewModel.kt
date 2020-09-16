package com.soumik.weatherzone.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soumik.weatherzone.data.models.Cities
import com.soumik.weatherzone.data.models.LocationData
import com.soumik.weatherzone.data.models.ResponseWeather
import com.soumik.weatherzone.data.repository.local.CityRepository
import com.soumik.weatherzone.data.repository.local.LocationProvider
import com.soumik.weatherzone.data.repository.remote.WeatherRepository
import com.soumik.weatherzone.utils.RequestCompleteListener
import com.soumik.weatherzone.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException


/**
 * Created by Soumik Bhattacharjee on 9/11/2020.
 * soumikcse07@gmail.com,http://soumikbhatt.github.io/
 */
class MyViewModel:ViewModel() {

    val tag = "ViewModel"

    //location live data
    val locationLiveData = MutableLiveData<LocationData>()
    val locationLiveDataFailure = MutableLiveData<String>()

    //weatherByLocation live data
    val weatherByLocation = MutableLiveData<Resource<ResponseWeather>>()

    //cityBySearch live data
    val cityByQuery = MutableLiveData<Resource<List<Cities>>>()

    fun getCurrentLocation(model: LocationProvider){
        model.getUserCurrentLocation(object : RequestCompleteListener<LocationData>{
            override fun onRequestCompleted(data: LocationData) {
                locationLiveData.postValue(data)
            }

            override fun onRequestFailed(errorMessage: String?) {
                locationLiveDataFailure.postValue(errorMessage)
            }
        })
    }

    fun getWeatherByLocation(model:WeatherRepository,lat:String,lon:String) {
        viewModelScope.launch {  safeWeatherByLocationFetch(model,lat,lon) }
    }

    private suspend fun safeWeatherByLocationFetch(model: WeatherRepository,lat: String,lon: String) {
        weatherByLocation.postValue(Resource.loading(null))
        try {
            val response = model.getWeatherByLocation(lat,lon)
            weatherByLocation.postValue(handleWeatherResponse(response))
        } catch (t:Throwable){
            when(t){
                is IOException -> weatherByLocation.postValue(Resource.error(null,"Network Failure"))
                else -> weatherByLocation.postValue(Resource.error(null,t.localizedMessage))
            }
        }
    }

    private fun handleWeatherResponse(response: Response<ResponseWeather>): Resource<ResponseWeather>? {
        return if (response.isSuccessful) Resource.success(response.body()) else Resource.error(null,"Error: ${response.errorBody()}")
    }

    fun getCityByQuery(model: CityRepository,query:String) = viewModelScope.launch { safeCityByQueryFetch(model,query) }

    private suspend fun safeCityByQueryFetch(model: CityRepository, query: String) {
        cityByQuery.postValue(Resource.loading(null))
        try {
            val response = model.searchCities(key = query)
            cityByQuery.postValue(handleCitySearch(response))
        } catch (t:Throwable){
            when(t) {
                is IOException -> cityByQuery.postValue(Resource.error(null,"Network Failure"))
                else -> {
                    cityByQuery.postValue(Resource.error(null,t.localizedMessage))
                    com.soumik.weatherzone.utils.error(tag,t.localizedMessage!!)
                }
            }
        }
    }

    private fun handleCitySearch(response: List<Cities>): Resource<List<Cities>>? = Resource.success(response)



}