package com.soumik.weatherzone.ui.main.activities

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Pair
import android.view.KeyEvent
import android.view.MenuItem
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
        navigateBack()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode==KeyEvent.KEYCODE_BACK) {
            navigateBack()
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun navigateBack() {
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }
}