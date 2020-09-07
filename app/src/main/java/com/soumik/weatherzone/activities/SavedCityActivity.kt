package com.soumik.weatherzone.activities

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Pair
import android.view.View
import com.soumik.weatherzone.R
import com.soumik.weatherzone.utils.lightStatusBar
import kotlinx.android.synthetic.main.activity_saved_city.*

class SavedCityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor=resources.getColor(android.R.color.white)
        lightStatusBar(this,true)
        window.navigationBarColor=resources.getColor(android.R.color.white)
        setContentView(R.layout.activity_saved_city)
    }

    fun onSearchTextClicked(view: View) {
        val intent = Intent(this@SavedCityActivity,SearchActivity::class.java)
        val options = ActivityOptions.makeSceneTransitionAnimation(this, Pair.create(tv_city_search,getString(R.string.label_search_hint)))
        startActivity(intent,options.toBundle())
    }

    fun onBackButtonClicked(view: View) {
        onBackPressed()
        finish()
    }
}