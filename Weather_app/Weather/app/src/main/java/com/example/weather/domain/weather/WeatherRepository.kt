package com.example.weather.domain.weather

import com.example.weather.domain.utils.Resource

//інтерфейс WeatherRepository для абстракції
interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}