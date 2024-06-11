package com.example.weather.data

import com.example.weather.domain.utils.Resource
import com.example.weather.domain.weather.WeatherInfo
import com.example.weather.domain.weather.WeatherRepository
import com.example.weather.data.remote.WeatherApi
import javax.inject.Inject

//реалізує інтерфейс WeatherRepository і забезпечує отримання погодних даних від api
class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}