package com.soumik.weatherzone.ui.main.adapters

import androidx.recyclerview.widget.DiffUtil
import com.soumik.weatherzone.data.models.Cities


/**
 * Created by Soumik Bhattacharjee on 9/17/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */
class DiffUtilCallback:DiffUtil.ItemCallback<Cities>() {
    override fun areItemsTheSame(oldItem: Cities, newItem: Cities): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: Cities, newItem: Cities): Boolean {
        return oldItem==newItem
    }
}