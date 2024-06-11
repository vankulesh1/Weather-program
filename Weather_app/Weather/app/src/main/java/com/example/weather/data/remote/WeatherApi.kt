package com.example.weather.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

//get-запит, який повертає інформацію про
// температуру, вологість, real feel температуру, вірогідність опадів, код погоди,
// атмосферний тиск, швидкість вітру, uv-індекс
// погодинно на 7 днів
interface WeatherApi {
    @GET("v1/forecast?hourly=temperature_2m,relative_humidity_2m,apparent_temperature,precipitation_probability,weather_code,surface_pressure,wind_speed_10m,uv_index")
    suspend fun getWeatherData(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double
    ): WeatherDto
}