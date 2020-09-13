package com.soumik.weatherzone.data.models
import com.google.gson.annotations.SerializedName



/**
 * Created by Soumik Bhattacharjee on 9/14/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */

data class ResponseCurrentConditionItem(
    @SerializedName("ApparentTemperature")
    val apparentTemperature: ApparentTemperature,
    @SerializedName("Ceiling")
    val ceiling: Ceiling,
    @SerializedName("CloudCover")
    val cloudCover: Int,
    @SerializedName("DewPoint")
    val dewPoint: DewPoint,
    @SerializedName("EpochTime")
    val epochTime: Int,
    @SerializedName("HasPrecipitation")
    val hasPrecipitation: Boolean,
    @SerializedName("IndoorRelativeHumidity")
    val indoorRelativeHumidity: Int,
    @SerializedName("IsDayTime")
    val isDayTime: Boolean,
    @SerializedName("Link")
    val link: String,
    @SerializedName("LocalObservationDateTime")
    val localObservationDateTime: String,
    @SerializedName("MobileLink")
    val mobileLink: String,
    @SerializedName("ObstructionsToVisibility")
    val obstructionsToVisibility: String,
    @SerializedName("Past24HourTemperatureDeparture")
    val past24HourTemperatureDeparture: Past24HourTemperatureDeparture,
    @SerializedName("Precip1hr")
    val precip1hr: Precip1hr,
    @SerializedName("PrecipitationSummary")
    val precipitationSummary: PrecipitationSummary,
    @SerializedName("PrecipitationType")
    val precipitationType: Any,
    @SerializedName("Pressure")
    val pressure: Pressure,
    @SerializedName("PressureTendency")
    val pressureTendency: PressureTendency,
    @SerializedName("RealFeelTemperature")
    val realFeelTemperature: RealFeelTemperature,
    @SerializedName("RealFeelTemperatureShade")
    val realFeelTemperatureShade: RealFeelTemperatureShade,
    @SerializedName("RelativeHumidity")
    val relativeHumidity: Int,
    @SerializedName("Temperature")
    val temperature: Temperature,
    @SerializedName("TemperatureSummary")
    val temperatureSummary: TemperatureSummary,
    @SerializedName("UVIndex")
    val uVIndex: Int,
    @SerializedName("UVIndexText")
    val uVIndexText: String,
    @SerializedName("Visibility")
    val visibility: Visibility,
    @SerializedName("WeatherIcon")
    val weatherIcon: Int,
    @SerializedName("WeatherText")
    val weatherText: String,
    @SerializedName("WetBulbTemperature")
    val wetBulbTemperature: WetBulbTemperature,
    @SerializedName("Wind")
    val wind: WindCurrentCondition,
    @SerializedName("WindChillTemperature")
    val windChillTemperature: WindChillTemperature,
    @SerializedName("WindGust")
    val windGust: WindGust
)

data class ApparentTemperature(
    @SerializedName("Imperial")
    val imperial: Imperial,
    @SerializedName("Metric")
    val metric: Metric
)

data class Ceiling(
    @SerializedName("Imperial")
    val imperial: ImperialX,
    @SerializedName("Metric")
    val metric: MetricX
)

data class DewPoint(
    @SerializedName("Imperial")
    val imperial: ImperialXX,
    @SerializedName("Metric")
    val metric: MetricXX
)

data class Past24HourTemperatureDeparture(
    @SerializedName("Imperial")
    val imperial: ImperialXXX,
    @SerializedName("Metric")
    val metric: MetricXXX
)

data class Precip1hr(
    @SerializedName("Imperial")
    val imperial: ImperialXXXX,
    @SerializedName("Metric")
    val metric: MetricXXXX
)

data class PrecipitationSummary(
    @SerializedName("Past12Hours")
    val past12Hours: Past12Hours,
    @SerializedName("Past18Hours")
    val past18Hours: Past18Hours,
    @SerializedName("Past24Hours")
    val past24Hours: Past24Hours,
    @SerializedName("Past3Hours")
    val past3Hours: Past3Hours,
    @SerializedName("Past6Hours")
    val past6Hours: Past6Hours,
    @SerializedName("Past9Hours")
    val past9Hours: Past9Hours,
    @SerializedName("PastHour")
    val pastHour: PastHour,
    @SerializedName("Precipitation")
    val precipitation: Precipitation
)

data class Pressure(
    @SerializedName("Imperial")
    val imperial: ImperialXXXXXXXXXXXXX,
    @SerializedName("Metric")
    val metric: MetricXXXXXXXXXXXXX
)

data class PressureTendency(
    @SerializedName("Code")
    val code: String,
    @SerializedName("LocalizedText")
    val localizedText: String
)

data class RealFeelTemperature(
    @SerializedName("Imperial")
    val imperial: ImperialXXXXXXXXXXXXXX,
    @SerializedName("Metric")
    val metric: MetricXXXXXXXXXXXXXX
)

data class RealFeelTemperatureShade(
    @SerializedName("Imperial")
    val imperial: ImperialXXXXXXXXXXXXXXX,
    @SerializedName("Metric")
    val metric: MetricXXXXXXXXXXXXXXX
)

data class Temperature(
    @SerializedName("Imperial")
    val imperial: ImperialXXXXXXXXXXXXXXXX,
    @SerializedName("Metric")
    val metric: MetricXXXXXXXXXXXXXXXX
)

data class TemperatureSummary(
    @SerializedName("Past12HourRange")
    val past12HourRange: Past12HourRange,
    @SerializedName("Past24HourRange")
    val past24HourRange: Past24HourRange,
    @SerializedName("Past6HourRange")
    val past6HourRange: Past6HourRange
)

data class Visibility(
    @SerializedName("Imperial")
    val imperial: ImperialXXXXXXXXXXXXXXXXXXXXXXX,
    @SerializedName("Metric")
    val metric: MetricXXXXXXXXXXXXXXXXXXXXXXX
)

data class WetBulbTemperature(
    @SerializedName("Imperial")
    val imperial: ImperialXXXXXXXXXXXXXXXXXXXXXXXX,
    @SerializedName("Metric")
    val metric: MetricXXXXXXXXXXXXXXXXXXXXXXXX
)

data class WindCurrentCondition(
    @SerializedName("Direction")
    val direction: Direction,
    @SerializedName("Speed")
    val speed: Speed
)

data class WindChillTemperature(
    @SerializedName("Imperial")
    val imperial: ImperialXXXXXXXXXXXXXXXXXXXXXXXXXX,
    @SerializedName("Metric")
    val metric: MetricXXXXXXXXXXXXXXXXXXXXXXXXXX
)

data class WindGust(
    @SerializedName("Speed")
    val speed: SpeedX
)

data class Imperial(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class Metric(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Double
)

data class ImperialX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class MetricX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class ImperialXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class MetricXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Double
)

data class ImperialXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class MetricXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Double
)

data class ImperialXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class MetricXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class Past12Hours(
    @SerializedName("Imperial")
    val imperial: ImperialXXXXX,
    @SerializedName("Metric")
    val metric: MetricXXXXX
)

data class Past18Hours(
    @SerializedName("Imperial")
    val imperial: ImperialXXXXXX,
    @SerializedName("Metric")
    val metric: MetricXXXXXX
)

data class Past24Hours(
    @SerializedName("Imperial")
    val imperial: ImperialXXXXXXX,
    @SerializedName("Metric")
    val metric: MetricXXXXXXX
)

data class Past3Hours(
    @SerializedName("Imperial")
    val imperial: ImperialXXXXXXXX,
    @SerializedName("Metric")
    val metric: MetricXXXXXXXX
)

data class Past6Hours(
    @SerializedName("Imperial")
    val imperial: ImperialXXXXXXXXX,
    @SerializedName("Metric")
    val metric: MetricXXXXXXXXX
)

data class Past9Hours(
    @SerializedName("Imperial")
    val imperial: ImperialXXXXXXXXXX,
    @SerializedName("Metric")
    val metric: MetricXXXXXXXXXX
)

data class PastHour(
    @SerializedName("Imperial")
    val imperial: ImperialXXXXXXXXXXX,
    @SerializedName("Metric")
    val metric: MetricXXXXXXXXXXX
)

data class Precipitation(
    @SerializedName("Imperial")
    val imperial: ImperialXXXXXXXXXXXX,
    @SerializedName("Metric")
    val metric: MetricXXXXXXXXXXXX
)

data class ImperialXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Double
)

data class MetricXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Double
)

data class ImperialXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Double
)

data class MetricXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Double
)

data class ImperialXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Double
)

data class MetricXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Double
)

data class ImperialXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class MetricXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class ImperialXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class MetricXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class ImperialXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Double
)

data class MetricXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Double
)

data class ImperialXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class MetricXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class ImperialXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class MetricXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class ImperialXXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Double
)

data class MetricXXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class ImperialXXXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class MetricXXXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Double
)

data class ImperialXXXXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class MetricXXXXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Double
)

data class ImperialXXXXXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class MetricXXXXXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Double
)

data class Past12HourRange(
    @SerializedName("Maximum")
    val maximum: Maximum,
    @SerializedName("Minimum")
    val minimum: Minimum
)

data class Past24HourRange(
    @SerializedName("Maximum")
    val maximum: MaximumX,
    @SerializedName("Minimum")
    val minimum: MinimumX
)

data class Past6HourRange(
    @SerializedName("Maximum")
    val maximum: MaximumXX,
    @SerializedName("Minimum")
    val minimum: MinimumXX
)

data class Maximum(
    @SerializedName("Imperial")
    val imperial: ImperialXXXXXXXXXXXXXXXXX,
    @SerializedName("Metric")
    val metric: MetricXXXXXXXXXXXXXXXXX
)

data class Minimum(
    @SerializedName("Imperial")
    val imperial: ImperialXXXXXXXXXXXXXXXXXX,
    @SerializedName("Metric")
    val metric: MetricXXXXXXXXXXXXXXXXXX
)

data class ImperialXXXXXXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class MetricXXXXXXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Double
)

data class ImperialXXXXXXXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class MetricXXXXXXXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Double
)

data class MaximumX(
    @SerializedName("Imperial")
    val imperial: ImperialXXXXXXXXXXXXXXXXXXX,
    @SerializedName("Metric")
    val metric: MetricXXXXXXXXXXXXXXXXXXX
)

data class MinimumX(
    @SerializedName("Imperial")
    val imperial: ImperialXXXXXXXXXXXXXXXXXXXX,
    @SerializedName("Metric")
    val metric: MetricXXXXXXXXXXXXXXXXXXXX
)

data class ImperialXXXXXXXXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class MetricXXXXXXXXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Double
)

data class ImperialXXXXXXXXXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class MetricXXXXXXXXXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Double
)

data class MaximumXX(
    @SerializedName("Imperial")
    val imperial: ImperialXXXXXXXXXXXXXXXXXXXXX,
    @SerializedName("Metric")
    val metric: MetricXXXXXXXXXXXXXXXXXXXXX
)

data class MinimumXX(
    @SerializedName("Imperial")
    val imperial: ImperialXXXXXXXXXXXXXXXXXXXXXX,
    @SerializedName("Metric")
    val metric: MetricXXXXXXXXXXXXXXXXXXXXXX
)

data class ImperialXXXXXXXXXXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class MetricXXXXXXXXXXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Double
)

data class ImperialXXXXXXXXXXXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class MetricXXXXXXXXXXXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Double
)

data class ImperialXXXXXXXXXXXXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class MetricXXXXXXXXXXXXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Double
)

data class ImperialXXXXXXXXXXXXXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class MetricXXXXXXXXXXXXXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class Direction(
    @SerializedName("Degrees")
    val degrees: Int,
    @SerializedName("English")
    val english: String,
    @SerializedName("Localized")
    val localized: String
)

data class Speed(
    @SerializedName("Imperial")
    val imperial: ImperialXXXXXXXXXXXXXXXXXXXXXXXXX,
    @SerializedName("Metric")
    val metric: MetricXXXXXXXXXXXXXXXXXXXXXXXXX
)

data class ImperialXXXXXXXXXXXXXXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Double
)

data class MetricXXXXXXXXXXXXXXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Double
)

data class ImperialXXXXXXXXXXXXXXXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Int
)

data class MetricXXXXXXXXXXXXXXXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Double
)

data class SpeedX(
    @SerializedName("Imperial")
    val imperial: ImperialXXXXXXXXXXXXXXXXXXXXXXXXXXX,
    @SerializedName("Metric")
    val metric: MetricXXXXXXXXXXXXXXXXXXXXXXXXXXX
)

data class ImperialXXXXXXXXXXXXXXXXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Double
)

data class MetricXXXXXXXXXXXXXXXXXXXXXXXXXXX(
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
    @SerializedName("Value")
    val value: Double
)