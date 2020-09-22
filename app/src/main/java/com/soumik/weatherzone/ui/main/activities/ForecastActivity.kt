package com.soumik.weatherzone.ui.main.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.soumik.weatherzone.R
import com.soumik.weatherzone.data.repository.remote.WeatherRepository
import com.soumik.weatherzone.ui.main.adapters.ForecastAdapter
import com.soumik.weatherzone.utils.Status
import com.soumik.weatherzone.utils.lightStatusBar
import com.soumik.weatherzone.viewmodel.MyViewModel
import kotlinx.android.synthetic.main.activity_forecast.*

class ForecastActivity : AppCompatActivity() {

    private lateinit var viewModel: MyViewModel
    private lateinit var repository: WeatherRepository
    private lateinit var mAdapter: ForecastAdapter
    private var lat:String?=null
    private var lon:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor=resources.getColor(android.R.color.white)
        lightStatusBar(this,true)
        window.navigationBarColor=resources.getColor(android.R.color.white)
        setContentView(R.layout.activity_forecast)

        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        repository = WeatherRepository()
        mAdapter = ForecastAdapter()

        lat = intent.getStringExtra(LATITUDE)
        lon = intent.getStringExtra(LONGITUDE)

        if (lat!=null && lon!=null) viewModel.getWeatherForecast(repository,lat!!,lon!!,EXCLUDE)

        setUpRecyclerView()
        setUpObservers()

    }

    private fun setUpObservers() {
        viewModel.weatherForecast.observe(this,{
            it?.let {resource ->
                when(resource.status) {
                    Status.SUCCESS-> {
                        progressBar.visibility=View.GONE
                        tv_error_msg.visibility=View.GONE
                        rv_forecast.visibility=View.VISIBLE
                        mAdapter.differ.submitList(it.data?.daily)
                    }
                    Status.ERROR-> {
                        progressBar.visibility=View.GONE
                        tv_error_msg.visibility=View.VISIBLE
                        rv_forecast.visibility=View.GONE
                        tv_error_msg.text = it.message
                    }
                    Status.LOADING-> {
                        progressBar.visibility=View.VISIBLE
                        tv_error_msg.visibility=View.GONE
                        rv_forecast.visibility=View.GONE
                    }
                }
            }
        })
    }

    private fun setUpRecyclerView() {
        rv_forecast.apply {
            layoutManager = LinearLayoutManager(this@ForecastActivity)
            setHasFixedSize(true)
            adapter = mAdapter
        }
    }

    fun onBackButtonClicked(view: View) {
        onBackPressed()
        finish()
    }


    companion object {
        const val LATITUDE = "lat"
        const val LONGITUDE = "lon"
        const val EXCLUDE = "current,minutely,hourly"
    }
}