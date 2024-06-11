package com.example.weather.domain.weather

import com.example.weather.domain.utils.WeatherType
import java.time.LocalDateTime

//дані про погоду в конкретний момент часу
data class WeatherData(
    val time: LocalDateTime,
    val temperatureCelsius: Double,
    val humidity: Double,
    val realFeel: Double,
    val precipitation: Int,
    val pressure: Double,
    val windSpeed: Double,
    val uvIndex: Double,
    val weatherType: WeatherType
)