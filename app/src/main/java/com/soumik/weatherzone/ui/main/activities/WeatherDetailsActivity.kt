package com.soumik.weatherzone.ui.main.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.soumik.weatherzone.R
import com.soumik.weatherzone.data.models.ResponseWeather
import com.soumik.weatherzone.data.repository.remote.WeatherRepository
import com.soumik.weatherzone.utils.Status
import com.soumik.weatherzone.utils.showToast
import com.soumik.weatherzone.utils.unixTimestampToTimeString
import com.soumik.weatherzone.viewmodel.MyViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_weather_details.*
import kotlinx.android.synthetic.main.activity_weather_details.anim_failed
import kotlinx.android.synthetic.main.activity_weather_details.anim_network
import kotlinx.android.synthetic.main.activity_weather_details.inc_info_weather
import kotlinx.android.synthetic.main.activity_weather_details.progressBar
import kotlinx.android.synthetic.main.layout_info.*
import kotlinx.android.synthetic.main.layout_additional_weather_info.*

class WeatherDetailsActivity : AppCompatActivity() {

    private lateinit var viewModel: MyViewModel
    private lateinit var weatherRepo: WeatherRepository
    private var cityID:String?=null
    private var lat:String?=null
    private var lon:String?=null
    private var city:String?=null

    companion object{
        const val CITY_ID = "city_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_details)

        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        weatherRepo = WeatherRepository()

        iv_add.setImageResource(R.drawable.ic_arrow_back_white)
        iv_more.visibility = View.GONE

        cityID = intent.getStringExtra(CITY_ID)

        viewModel.getWeatherByCityID(weatherRepo,cityID!!)

        setUpObservers()

    }

    private fun setUpObservers() {
        viewModel.weatherByCityID.observe(this,{
            it?.let {resource ->
                when(resource.status){
                    Status.SUCCESS->{
                        inc_info_weather.visibility=View.VISIBLE
                        progressBar.visibility=View.GONE
                        anim_failed.visibility=View.GONE
                        anim_network.visibility=View.GONE
                        setUpUI(it.data)
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

    fun onAddButtonClicked(view: View) {
        onBackPressed()
        finish()
    }

    fun onForecastButtonClicked(view: View) {
        startActivity(Intent(this@WeatherDetailsActivity,ForecastActivity::class.java)
            .putExtra(ForecastActivity.LATITUDE,lat)
            .putExtra(ForecastActivity.LONGITUDE,lon)
            .putExtra(ForecastActivity.CITY_NAME,city))
        finish()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}