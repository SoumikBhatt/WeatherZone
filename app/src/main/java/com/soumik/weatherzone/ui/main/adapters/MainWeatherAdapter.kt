package com.soumik.weatherzone.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.soumik.weatherzone.R


/**
 * Created by Soumik Bhattacharjee on 9/13/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */
class MainWeatherAdapter:RecyclerView.Adapter<MainWeatherAdapter.Holder>() {
    class Holder(itemView:View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_cities,parent,false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}