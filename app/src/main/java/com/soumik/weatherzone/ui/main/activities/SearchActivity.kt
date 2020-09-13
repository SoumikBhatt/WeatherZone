package com.soumik.weatherzone.ui.main.activities

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Pair
import android.view.KeyEvent
import android.view.View
import com.soumik.weatherzone.R
import com.soumik.weatherzone.utils.lightStatusBar
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor=resources.getColor(android.R.color.white)
        lightStatusBar(this,true)
        window.navigationBarColor=resources.getColor(android.R.color.white)
        setContentView(R.layout.activity_search)
    }

    fun onCancelButtonClicked(view: View) {
        navigateBack()
    }

    private fun navigateBack() {
        val intent = Intent(this@SearchActivity, SavedCityActivity::class.java)
        val options = ActivityOptions.makeSceneTransitionAnimation(
            this,
            Pair.create(sv_search_city, getString(R.string.label_search_hint))
        )
        startActivity(intent, options.toBundle())
        Handler().postDelayed({ finish() }, 1000)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode==KeyEvent.KEYCODE_BACK) {
            navigateBack()
        }
        return super.onKeyDown(keyCode, event)
    }
}