package com.example.weather.data.remote

import com.squareup.moshi.Json

//погодні дані, отримані з апі
data class WeatherDto(
    @Json(name = "hourly")
    val weatherData: WeatherDataDto
)
