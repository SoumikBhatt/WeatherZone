package com.soumik.weatherzone.ui.main.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.soumik.weatherzone.R
import com.soumik.weatherzone.data.models.Cities
import com.soumik.weatherzone.utils.showToast
import kotlinx.android.synthetic.main.item_cities.view.*


/**
 * Created by Soumik Bhattacharjee on 9/13/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */
class CityAdapter(private val context:Context):RecyclerView.Adapter<CityAdapter.Holder>() {
    class Holder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val cityName = itemView.tv_city_name!!
        val countryName = itemView.tv_country_name!!
        val addBtn = itemView.iv_add_city!!
    }

    private val differCallback = object: DiffUtil.ItemCallback<Cities>(){
        override fun areItemsTheSame(oldItem: Cities, newItem: Cities): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: Cities, newItem: Cities): Boolean {
            return oldItem==newItem
        }
    }
    val differ = AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_cities,parent,false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val cities = differ.currentList[position]
        bindData(holder,cities)
    }

    private fun bindData(holder: Holder, cities: Cities?) {
        holder.apply {
            cityName.text = cities?.name
            countryName.text = cities?.country
            addBtn.setOnClickListener { showToast(context,"To add on DB",0) }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}