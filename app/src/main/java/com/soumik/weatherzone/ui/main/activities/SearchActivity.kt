package com.soumik.weatherzone.ui.main.activities

import android.app.ActivityOptions
import android.content.Intent
import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Pair
import android.view.KeyEvent
import android.view.View
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.soumik.weatherzone.R
import com.soumik.weatherzone.data.models.Cities
import com.soumik.weatherzone.data.models.CityUpdate
import com.soumik.weatherzone.data.repository.local.CityRepository
import com.soumik.weatherzone.db.CityDatabase
import com.soumik.weatherzone.ui.main.adapters.CityAdapter
import com.soumik.weatherzone.utils.Status
import com.soumik.weatherzone.utils.lightStatusBar
import com.soumik.weatherzone.viewmodel.MyViewModel
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    private lateinit var viewModel : MyViewModel
    private lateinit var repository: CityRepository
    private lateinit var database: CityDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor=resources.getColor(android.R.color.white)
        lightStatusBar(this,true)
        window.navigationBarColor=resources.getColor(android.R.color.white)
        setContentView(R.layout.activity_search)

        database = CityDatabase(this)
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        repository = CityRepository(database)

        sv_search_city.requestFocus()

        setUpUI()
        setUpObservers()
    }

    private fun setUpObservers() {
        viewModel.cityByQuery.observe(this,{
            it?.let { resource ->
                when(resource.status) {
                    Status.SUCCESS-> {
                        if (it.data!!.isNotEmpty()) {
                            pb_search.visibility=View.GONE
                            rv_searched_result.visibility=View.VISIBLE
                            //set data to recycler view
                            setUpRecyclerView(it.data)
                        } else {
                            pb_search.visibility=View.GONE
                            rv_searched_result.visibility=View.GONE
                            tv_no_result.visibility=View.VISIBLE
                        }
                    }
                    Status.ERROR->{
                       showFailedView(it.message)
                    }
                    Status.LOADING ->{
                        pb_search.visibility=View.VISIBLE
                        rv_searched_result.visibility=View.GONE
                        tv_no_result.visibility=View.GONE
                    }
                }
            }
        })
    }

    private fun setUpRecyclerView(data: List<Cities>) {
        val cityAdapter = CityAdapter()
        rv_searched_result.apply {
            layoutManager = LinearLayoutManager(this@SearchActivity)
            setHasFixedSize(true)
            adapter = cityAdapter
        }
        cityAdapter.differ.submitList(data)

        cityAdapter.setOnItemClickListener { viewModel.updateSavedCities(repository, CityUpdate(it.id,1)) }
    }

    private fun setUpUI() {
        sv_search_city.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                val searchedQuery = if (query!!.contains("'")) DatabaseUtils.sqlEscapeString(query).replace("'","") else query
                viewModel.getCityByQuery(repository,searchedQuery)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val searchedQuery = if (newText!!.contains("'")) DatabaseUtils.sqlEscapeString(newText).replace("'","") else newText
                viewModel.getCityByQuery(repository,searchedQuery)
                return false
            }

        })
    }

    private fun showFailedView(message:String?){
        pb_search.visibility=View.GONE
        rv_searched_result.visibility=View.GONE
        tv_no_result.visibility=View.VISIBLE
        tv_no_result.text = message
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
        Handler(Looper.myLooper()!!).postDelayed({ finish() }, 1000)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode==KeyEvent.KEYCODE_BACK) {
            navigateBack()
        }
        return super.onKeyDown(keyCode, event)
    }
}