package com.soumik.weatherzone.data.models
import com.google.gson.annotations.SerializedName



/**
 * Created by Soumik Bhattacharjee on 9/14/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */
data class ResponseForecast(
    @SerializedName("DailyForecasts")
    val dailyForecasts: List<DailyForecast>,
    @SerializedName("Headline")
    val headline: Headline
)

data class DailyForecast(
    @SerializedName("Date")
    val date: String,
    @SerializedName("Day")
    val day: Day,
    @SerializedName("EpochDate")
    val epochDate: Int,
    @SerializedName("Link")
    val link: String,
    @SerializedName("MobileLink")
    val mobileLink: String,
    @SerializedName("Night")
    val night: Night,
    @SerializedName("Sources")
    val sources: List<String>,
    @SerializedName("Temperature")
    val temperature: TemperatureForecast
)

data class Headline(
    @SerializedName("Category")
    val category: String,
    @SerializedName("EffectiveDate")
    val effectiveDate: String,
    @SerializedName("EffectiveEpochDate")
    val effectiveEpochDate: Int,
    @SerializedName("EndDate")
    val endDate: String,
    @SerializedName("EndEpochDate")
    val endEpochDate: Int,
    @SerializedName("Link")
    val link: String,
    @SerializedName("MobileLink")
    val mobileLink: String,
    @SerializedName("Severity")
    val severity: Int,
    @SerializedName("Text")
    val text: String
)

data class Day(
    @SerializedName("HasPrecipitation")
    val hasPrecipitation: Boolean,
    @SerializedName("Icon")
    val icon: Int,
    @SerializedName("IconPhrase")
    val iconPhrase: String,
    @SerializedName("PrecipitationIntensity")
    val precipitationIntensity: String,
    @SerializedName("PrecipitationType")
    val precipitationType: String
)

data class Night(
    @SerializedName("HasPrecipitation")
    val hasPrecipitation: Boolean,
    @SerializedName("Icon")
    val icon: Int,
    @SerializedName("IconPhrase")
    val iconPhrase: String,
    @SerializedName("PrecipitationIntensity")
    val precipitationIntensity: String,
    @SerializedName("PrecipitationType")
    val precipitationType: String
)

data class TemperatureForecast(
    @SerializedName("Maximum")
    val maximum: MaximumForecast,
    @SerializedName("Minimum")
    val minimum: MinimumForecast
)

data class MaximumForecast(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class MinimumForecast(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)