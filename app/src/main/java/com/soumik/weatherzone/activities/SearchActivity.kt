package com.soumik.weatherzone.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.soumik.weatherzone.R
import com.soumik.weatherzone.utils.lightStatusBar
import com.soumik.weatherzone.utils.showToast

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor=resources.getColor(android.R.color.white)
        lightStatusBar(this,true)
        window.navigationBarColor=resources.getColor(android.R.color.white)
        setContentView(R.layout.activity_search)
    }

    fun onSearchTextClicked(view: View) {
        showToast(applicationContext,"Clicked!!",0)}
}