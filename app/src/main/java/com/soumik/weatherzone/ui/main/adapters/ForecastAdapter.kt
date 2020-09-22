package com.soumik.weatherzone.ui.main.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.soumik.weatherzone.R
import com.soumik.weatherzone.data.models.Daily
import com.soumik.weatherzone.utils.unixTimestampToDateTimeString
import com.soumik.weatherzone.utils.unixTimestampToTimeString
import kotlinx.android.synthetic.main.item_forecast.view.*
import kotlinx.android.synthetic.main.layout_forecast_info.view.*


/**
 * Created by Soumik Bhattacharjee on 9/23/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */
class ForecastAdapter():RecyclerView.Adapter<ForecastAdapter.Holder>() {

    val differ = AsyncListDiffer(this,DiffUtilCallbackForecast())

    class Holder(itemView:View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_forecast,parent,false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = differ.currentList[position]
        bindData(holder,data)
    }

    @SuppressLint("SetTextI18n")
    private fun bindData(holder: Holder, data: Daily?) {
        val weatherConditionIconUrl = "http://openweathermap.org/img/w/${data!!.weather[0].icon}.png"
        holder.itemView.apply {
            tv_time_forecast.text = data.dt.unixTimestampToDateTimeString()
            if(!(context as Activity).isFinishing) Glide.with(context).load(weatherConditionIconUrl).into(iv_weather_icon)
            tv_weather_condition.text = data.weather[0].main
            tv_day_temp.text = "Day\n${data.temp.day}${context.getString(R.string.degree_celsius_symbol)}"
            tv_eve_temp.text = "Evening\n${data.temp.eve}${context.getString(R.string.degree_celsius_symbol)}"
            tv_night_temp.text = "Night\n${data.temp.night}${context.getString(R.string.degree_celsius_symbol)}"
            tv_max_temp.text = "Max\n${data.temp.max}${context.getString(R.string.degree_celsius_symbol)}"
            tv_min_temp.text = "Min\n${data.temp.min}${context.getString(R.string.degree_celsius_symbol)}"

            tv_morn_feel.text = "Morning\n${data.feelsLike.morn}${context.getString(R.string.degree_celsius_symbol)}"
            tv_day_feel.text = "Day\n${data.feelsLike.day}${context.getString(R.string.degree_celsius_symbol)}"
            tv_eve_feel.text = "Evening\n${data.feelsLike.eve}${context.getString(R.string.degree_celsius_symbol)}"
            tv_night_feel.text = "Night\n${data.feelsLike.night}${context.getString(R.string.degree_celsius_symbol)}"

            tv_sunrise_time.text = data.sunrise.unixTimestampToTimeString()
            tv_sunset_time.text = data.sunset.unixTimestampToTimeString()
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}