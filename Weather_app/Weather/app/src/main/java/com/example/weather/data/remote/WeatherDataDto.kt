package com.example.weather.data.remote

import com.squareup.moshi.Json

//погодні дані по годинах
data class WeatherDataDto(
    val time: List<String>,
    @Json(name = "temperature_2m")
    val temperatures: List<Double>,
    @Json(name = "relative_humidity_2m")
    val humidities: List<Double>,
    @Json(name = "apparent_temperature")
    val realFeelTemperatures: List<Double>,
    @Json(name = "precipitation_probability")
    val precipitationProbability: List<Int>,
    @Json(name = "weather_code")
    val weatherCodes: List<Int>,
    @Json(name = "surface_pressure")
    val pressures: List<Double>,
    @Json(name = "wind_speed_10m")
    val windSpeeds: List<Double>,
    @Json(name = "uv_index")
    val uvIndexes: List<Double>
)