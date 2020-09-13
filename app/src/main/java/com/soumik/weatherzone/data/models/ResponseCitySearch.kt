package com.soumik.weatherzone.data.models
import com.google.gson.annotations.SerializedName



/**
 * Created by Soumik Bhattacharjee on 9/14/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */
data class ResponseCitySearchItem(
    @SerializedName("AdministrativeArea")
    val administrativeArea: AdministrativeArea,
    @SerializedName("Country")
    val country: Country,
    @SerializedName("Key")
    val key: String,
    @SerializedName("LocalizedName")
    val localizedName: String,
    @SerializedName("Rank")
    val rank: Int,
    @SerializedName("Type")
    val type: String,
    @SerializedName("Version")
    val version: Int
)

data class AdministrativeArea(
    @SerializedName("ID")
    val iD: String,
    @SerializedName("LocalizedName")
    val localizedName: String
)

data class Country(
    @SerializedName("ID")
    val iD: String,
    @SerializedName("LocalizedName")
    val localizedName: String
)