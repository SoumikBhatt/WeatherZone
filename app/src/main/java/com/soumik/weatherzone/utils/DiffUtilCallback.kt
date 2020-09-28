package com.soumik.weatherzone.utils

import androidx.recyclerview.widget.DiffUtil
import com.soumik.weatherzone.data.models.Cities
import com.soumik.weatherzone.data.models.Daily
import com.soumik.weatherzone.data.models.ResponseWeatherForecast


/**
 * Created by Soumik Bhattacharjee on 9/17/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */
class  DiffUtilCallback:DiffUtil.ItemCallback<Cities>() {
    override fun areItemsTheSame(oldItem: Cities, newItem: Cities): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: Cities, newItem: Cities): Boolean {
        return oldItem==newItem
    }
}

class DiffUtilCallbackForecast:DiffUtil.ItemCallback<Daily>(){
    override fun areItemsTheSame(oldItem: Daily, newItem: Daily): Boolean {
        return oldItem.dt==newItem.dt
    }

    override fun areContentsTheSame(oldItem: Daily, newItem: Daily): Boolean {
        return oldItem==newItem
    }

}