package com.soumik.weatherzone.ui.main.activities

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import com.soumik.weatherzone.R
import com.soumik.weatherzone.data.models.CityUpdate
import com.soumik.weatherzone.data.models.ResponseWeather
import com.soumik.weatherzone.data.repository.local.CityRepository
import com.soumik.weatherzone.data.repository.local.LocationProvider
import com.soumik.weatherzone.data.repository.remote.WeatherRepository
import com.soumik.weatherzone.db.CityDatabase
import com.soumik.weatherzone.ui.main.adapters.ForecastAdapter
import com.soumik.weatherzone.utils.*
import com.soumik.weatherzone.viewmodel.MyViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_info.*
import kotlinx.android.synthetic.main.layout_additional_weather_info.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel:MyViewModel
    private lateinit var model: LocationProvider
    private lateinit var weatherRepo:WeatherRepository
    private lateinit var cityRepo:CityRepository
    private var isGPSEnabled = false
    private var lat:String?=null
    private var lon:String?=null
    private var city:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        model = LocationProvider(this)
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        weatherRepo = WeatherRepository()
        cityRepo = CityRepository(CityDatabase(this))

        //checking GPS status
        GpsUtils(this).turnGPSOn(object : GpsUtils.OnGpsListener {

            override fun gpsStatus(isGPSEnable: Boolean) {
                this@MainActivity.isGPSEnabled = isGPSEnable
            }
        })

        setUpObservers()
    }

    override fun onStart() {
        super.onStart()
        invokeLocationAction()
    }

    private fun setUpObservers() {
        viewModel.locationLiveData.observe(this, {
            viewModel.getWeatherByLocation(weatherRepo,it.latitude.toString(),it.longitude.toString())
        })

        viewModel.weatherByLocation.observe(this,{
            it?.let {resource ->
                when(resource.status){
                    Status.SUCCESS->{
                        inc_info_weather.visibility=View.VISIBLE
                        progressBar.visibility=View.GONE
                        anim_failed.visibility=View.GONE
                        anim_network.visibility=View.GONE
                        setUpUI(it.data)
                        viewModel.updateSavedCities(cityRepo, CityUpdate(it.data?.id,1))
                    }
                    Status.ERROR->{
                        showFailedView(it.message)
                    }
                    Status.LOADING->{
                        progressBar.visibility=View.VISIBLE
                        anim_failed.visibility=View.GONE
                        anim_network.visibility=View.GONE
                    }
                }
            }
        })


    }

    private fun showFailedView(message: String?) {
        progressBar.visibility=View.GONE
        inc_info_weather.visibility=View.GONE

        when(message){
            "Network Failure" -> {
                anim_failed.visibility=View.GONE
                anim_network.visibility=View.VISIBLE
            }
            else ->{
                anim_network.visibility=View.GONE
                anim_failed.visibility=View.VISIBLE
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setUpUI(data: ResponseWeather?) {
        tv_temp.text = data?.main?.temp.toString()
        tv_city_name.text = data?.name
        tv_weather_condition.text = data?.weather!![0].main
        tv_sunrise_time.text = data.sys.sunrise.unixTimestampToTimeString()
        tv_sunset_time.text = data.sys.sunset.unixTimestampToTimeString()
        tv_real_feel_text.text = "${data.main.feelsLike}${getString(R.string.degree_celsius_symbol)}"
        tv_cloudiness_text.text = "${data.clouds.all}%"
        tv_wind_speed_text.text = "${data.wind.speed}m/s"
        tv_humidity_text.text = "${data.main.humidity}%"
        tv_pressure_text.text = "${data.main.pressure}hPa"
        tv_visibility_text.text = "${data.visibility}M"

        lat = data.coord.lat.toString()
        lon = data.coord.lon.toString()
        city = data.name
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == GPS_REQUEST) {
                isGPSEnabled = true
                invokeLocationAction()
            }
        }
    }

    private fun invokeLocationAction() {
        when {
            !isGPSEnabled -> showToast(this,"Enable GPS",1)

            isPermissionsGranted() -> startLocationUpdate()

            shouldShowRequestPermissionRationale() -> requestLocationPermission()

            else -> requestLocationPermission()
        }
    }

    private fun requestLocationPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ),
            LOCATION_REQUEST
        )
    }

    private fun startLocationUpdate() {
        viewModel.getCurrentLocation(model)
    }

    private fun isPermissionsGranted() =
        ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED

    private fun shouldShowRequestPermissionRationale() =
        ActivityCompat.shouldShowRequestPermissionRationale(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) && ActivityCompat.shouldShowRequestPermissionRationale(
            this,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )

    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            LOCATION_REQUEST -> {
                invokeLocationAction()
            }
        }
    }

    fun onAddButtonClicked(view: View) {
        startActivity(Intent(this@MainActivity,SavedCityActivity::class.java))
    }

    fun onForecastButtonClicked(view: View) {
        startActivity(Intent(this@MainActivity,ForecastActivity::class.java)
            .putExtra(ForecastActivity.LATITUDE,lat)
            .putExtra(ForecastActivity.LONGITUDE,lon)
            .putExtra(ForecastActivity.CITY_NAME,city))
    }

    fun onMoreOptionClicked(view: View) {
        showMoreOptions(this@MainActivity)
    }
}