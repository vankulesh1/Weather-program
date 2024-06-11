package com.example.weather.domain.weather

//дані про погоду згруповані по дням та інформація про поточнц погоду
data class WeatherInfo(
    val weatherDataPerDay: Map<Int, List<WeatherData>>,
    val currentWeatherData: WeatherData?
)