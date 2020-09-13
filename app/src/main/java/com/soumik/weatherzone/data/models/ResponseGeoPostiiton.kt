package com.soumik.weatherzone.data.models
import com.google.gson.annotations.SerializedName



/**
 * Created by Soumik Bhattacharjee on 9/14/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */

data class ResponseGeoPosition(
    @SerializedName("AdministrativeArea")
    val administrativeArea: AdministrativeAreaGP,
    @SerializedName("Country")
    val country: CountryGP,
    @SerializedName("DataSets")
    val dataSets: List<String>,
    @SerializedName("EnglishName")
    val englishName: String,
    @SerializedName("GeoPosition")
    val geoPosition: GeoPosition,
    @SerializedName("IsAlias")
    val isAlias: Boolean,
    @SerializedName("Key")
    val key: String,
    @SerializedName("LocalizedName")
    val localizedName: String,
    @SerializedName("PrimaryPostalCode")
    val primaryPostalCode: String,
    @SerializedName("Rank")
    val rank: Int,
    @SerializedName("Region")
    val region: Region,
    @SerializedName("SupplementalAdminAreas")
    val supplementalAdminAreas: List<Any>,
    @SerializedName("TimeZone")
    val timeZone: TimeZone,
    @SerializedName("Type")
    val type: String,
    @SerializedName("Version")
    val version: Int
)

data class AdministrativeAreaGP(
    @SerializedName("CountryID")
    val countryID: String,
    @SerializedName("EnglishName")
    val englishName: String,
    @SerializedName("EnglishType")
    val englishType: String,
    @SerializedName("ID")
    val iD: String,
    @SerializedName("Level")
    val level: Int,
    @SerializedName("LocalizedName")
    val localizedName: String,
    @SerializedName("LocalizedType")
    val localizedType: String
)

data class CountryGP(
    @SerializedName("EnglishName")
    val englishName: String,
    @SerializedName("ID")
    val iD: String,
    @SerializedName("LocalizedName")
    val localizedName: String
)

data class GeoPosition(
    @SerializedName("Elevation")
    val elevation: Elevation,
    @SerializedName("Latitude")
    val latitude: Double,
    @SerializedName("Longitude")
    val longitude: Double
)

data class Region(
    @SerializedName("EnglishName")
    val englishName: String,
    @SerializedName("ID")
    val iD: String,
    @SerializedName("LocalizedName")
    val localizedName: String
)

data class TimeZone(
    @SerializedName("Code")
    val code: String,
    @SerializedName("GmtOffset")
    val gmtOffset: Int,
    @SerializedName("IsDaylightSaving")
    val isDaylightSaving: Boolean,
    @SerializedName("Name")
    val name: String,
    @SerializedName("NextOffsetChange")
    val nextOffsetChange: Any
)

data class Elevation(
    @SerializedName("Imperial")
    val imperial: ImperialGP,
    @SerializedName("Metric")
    val metric: MetricGP
)

data class ImperialGP(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class MetricGP(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)