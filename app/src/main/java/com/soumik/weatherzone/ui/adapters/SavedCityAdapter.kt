package com.soumik.weatherzone.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.soumik.weatherzone.R
import com.soumik.weatherzone.data.models.Cities
import com.soumik.weatherzone.utils.DiffUtilCallback
import kotlinx.android.synthetic.main.item_saved_city.view.*


/**
 * Created by Soumik Bhattacharjee on 9/17/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */
class SavedCityAdapter:RecyclerView.Adapter<SavedCityAdapter.Holder>() {

    val differ = AsyncListDiffer(this, DiffUtilCallback())
    private var onItemClickListener : ((Cities)->Unit)?=null

    fun setOnItemClickListener(listener: (Cities)->Unit){
        onItemClickListener = listener
    }

    class Holder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val cityName = itemView.tv_city_name_search!!
        val countryName = itemView.tv_country_name_search!!
        val temperature = itemView.tv_city_temp!!
        val foregroundView = itemView.view_foreground!!
        val backgroundView = itemView.view_background!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_saved_city,parent,false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val cities = differ.currentList[position]
        bindData(cities,holder)
    }

    private fun bindData(cities: Cities?, holder: Holder) {
        holder.apply {
            cityName.text = cities?.name
            countryName.text = cities?.country
            temperature.text = ""
            itemView.setOnClickListener { onItemClickListener?.let { it(cities!!) } }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


}