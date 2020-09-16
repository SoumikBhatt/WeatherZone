package com.soumik.weatherzone.ui.main.activities

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Pair
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.soumik.weatherzone.R
import com.soumik.weatherzone.data.repository.local.CityRepository
import com.soumik.weatherzone.db.CityDatabase
import com.soumik.weatherzone.ui.main.adapters.SavedCityAdapter
import com.soumik.weatherzone.utils.lightStatusBar
import com.soumik.weatherzone.utils.showToast
import com.soumik.weatherzone.viewmodel.MyViewModel
import kotlinx.android.synthetic.main.activity_saved_city.*

class SavedCityActivity : AppCompatActivity() {

    private lateinit var viewModel : MyViewModel
    private lateinit var repository: CityRepository
    private lateinit var mAdapter : SavedCityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor=resources.getColor(android.R.color.white)
        lightStatusBar(this,true)
        window.navigationBarColor=resources.getColor(android.R.color.white)
        setContentView(R.layout.activity_saved_city)

        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        repository = CityRepository(CityDatabase(this))
        mAdapter = SavedCityAdapter()

        setUpRecyclerView()
        setUpObservers()
    }

    private fun setUpObservers() {
        viewModel.getSavedCities(repository,1).observe(this,{ cities->
            mAdapter.differ.submitList(cities)
        })
    }

    private fun setUpRecyclerView() {
        rv_saved_city.apply {
            layoutManager = LinearLayoutManager(this@SavedCityActivity)
            setHasFixedSize(true)
            adapter = mAdapter
        }

        mAdapter.setOnItemClickListener {
            showToast(this@SavedCityActivity,"Work in progress!!",0)
        }
    }

    fun onSearchTextClicked(view: View) {
        val intent = Intent(this@SavedCityActivity,SearchActivity::class.java)
        val options = ActivityOptions.makeSceneTransitionAnimation(this, Pair.create(tv_city_search,getString(R.string.label_search_hint)))
        startActivity(intent,options.toBundle())
        Handler(Looper.myLooper()!!).postDelayed({ finish() }, 1000)
    }

    fun onBackButtonClicked(view: View) {
        onBackPressed()
        finish()
    }

//
//    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
//        if (keyCode==KeyEvent.KEYCODE_BACK) {
//            navigateBack()
//        }
//        return super.onKeyDown(keyCode, event)
//    }
//
//    private fun navigateBack() {
//        startActivity(Intent(this,MainActivity::class.java))
//        finish()
//    }
}