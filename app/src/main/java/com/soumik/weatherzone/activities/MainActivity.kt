package com.soumik.weatherzone.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.soumik.weatherzone.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onAddButtonClicked(view: View) {
        startActivity(Intent(this@MainActivity,SavedCityActivity::class.java))
    }
}