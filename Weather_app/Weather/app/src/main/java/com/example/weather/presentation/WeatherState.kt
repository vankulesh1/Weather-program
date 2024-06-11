package com.example.weather.presentation

import com.example.weather.domain.weather.WeatherInfo

//стан, який використовується в WeatherViewModel для представлення інформації про погоду
data class WeatherState (
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)