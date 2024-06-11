package com.example.weather.data

import co.yml.charts.common.model.Point
import com.example.weather.domain.weather.WeatherData
import com.example.weather.domain.weather.WeatherInfo
import com.example.weather.domain.utils.WeatherType
import com.example.weather.data.remote.WeatherDataDto
import com.example.weather.data.remote.WeatherDto
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

//перетворення даних у зручний для роботи формат
private data class IndexedWeatherData(
    val index: Int,
    val data: WeatherData
)

fun WeatherDataDto.toWeatherDataMap(): Map<Int, List<WeatherData>> {
    return time.mapIndexed { index, time ->
        val temperature = temperatures[index]
        val humidity = humidities[index]
        val realFeel = realFeelTemperatures[index]
        val precipitation = precipitationProbability[index]
        val pressure = pressures[index]
        val windSpeed = windSpeeds[index]
        val weatherCode = weatherCodes[index]
        val uvIndex = uvIndexes[index]

        IndexedWeatherData(
            index = index,
            data = WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temperature,
                humidity = humidity,
                realFeel = realFeel,
                precipitation = precipitation,
                pressure = pressure,
                windSpeed = windSpeed,
                uvIndex = uvIndex,
                weatherType = WeatherType.fromWMO(weatherCode)
            )
        )
    }.groupBy {
        it.index / 24
    }.mapValues {
        it.value.map { it.data }
    }
}

fun WeatherDto.toWeatherInfo(): WeatherInfo {
    val weatherDataMap = weatherData.toWeatherDataMap()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = when {
            now.minute < 30 -> now.hour
            now.hour == 23 -> 12
            else -> now.hour + 1
        }
        it.time.hour == hour
    }
    return WeatherInfo(
        weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData
    )
}

data class DailyWeather(
    val date: String,
    val minTemperature: Double,
    val maxTemperature: Double,
    val weatherCode: Int
)

fun mapWeatherData(weatherDataMap: Map<Int, List<WeatherData>>): List<DailyWeather> {
    val dailyWeatherList = mutableListOf<DailyWeather>()

    for ((_, weatherDataList) in weatherDataMap) {
        if (weatherDataList.isNotEmpty()) {
            val minTemperature = weatherDataList.minByOrNull { it.temperatureCelsius }?.temperatureCelsius ?: Double.NaN
            val maxTemperature = weatherDataList.maxByOrNull { it.temperatureCelsius }?.temperatureCelsius ?: Double.NaN
            val weatherCode = weatherDataList.groupingBy { it.weatherType }.eachCount().maxByOrNull { it.value}?.key?.iconRes ?: weatherDataList.first().weatherType.iconRes
            val date = weatherDataList.first().time.toLocalDate().dayOfWeek.toString()

            dailyWeatherList.add(DailyWeather(date, minTemperature, maxTemperature, weatherCode))
        }
    }
    return dailyWeatherList
}
