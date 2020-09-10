package com.soumik.weatherzone.activities

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
import com.soumik.weatherzone.models.repository.LocationProvider
import com.soumik.weatherzone.utils.GPS_REQUEST
import com.soumik.weatherzone.utils.GpsUtils
import com.soumik.weatherzone.utils.LOCATION_REQUEST
import com.soumik.weatherzone.utils.showToast
import com.soumik.weatherzone.viewmodel.MyViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel:MyViewModel
    private lateinit var model:LocationProvider
    private var isGPSEnabled = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        model = LocationProvider(this)
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        //checking GPS status
        GpsUtils(this).turnGPSOn(object : GpsUtils.OnGpsListener {

            override fun gpsStatus(isGPSEnable: Boolean) {
                this@MainActivity.isGPSEnabled = isGPSEnable
            }
        })

        liveDataListener()
    }

    override fun onStart() {
        super.onStart()
        invokeLocationAction()
    }

    private fun liveDataListener() {
        viewModel.locationLiveData.observe(this, {
            showToast(this,"You are at Lat:${it.latitude}...Lng:${it.longitude}",1)
        })
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

            shouldShowRequestPermissionRationale() -> showToast(this,"Location Permission needed",1)

            else -> ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION),
                LOCATION_REQUEST
            )
        }
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
        startActivity(Intent(this@MainActivity,ForecastActivity::class.java))
    }
}