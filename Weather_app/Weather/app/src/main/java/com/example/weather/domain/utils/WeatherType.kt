package com.example.weather.domain.utils

import androidx.annotation.DrawableRes
import com.example.weather.R

//пов'язує опис погоди з відповідною іконкою та анімацією lottie
sealed class WeatherType(
    val weatherDesc: String,
    @DrawableRes val iconRes: Int,
    val lottieAnimation: Int
) {
    object ClearSky : WeatherType(
        weatherDesc = "Clear sky",
        iconRes = R.drawable.sun,
        lottieAnimation = R.raw.sunny_lottie
    )
    object MainlyClear : WeatherType(
        weatherDesc = "Mainly clear",
        iconRes = R.drawable.partly_cloudy,
        lottieAnimation = R.raw.partly_cloudly_lottie
    )
    object PartlyCloudy : WeatherType(
        weatherDesc = "Partly cloudy",
        iconRes = R.drawable.partly_cloudy,
        lottieAnimation = R.raw.partly_cloudly_lottie
    )
    object Overcast : WeatherType(
        weatherDesc = "Overcast",
        iconRes = R.drawable.cloudly,
        lottieAnimation = R.raw.cloudly_lottie
    )
    object Foggy : WeatherType(
        weatherDesc = "Foggy",
        iconRes = R.drawable.cloudly,
        lottieAnimation = R.raw.cloudly_lottie
    )
    object DepositingRimeFog : WeatherType(
        weatherDesc = "Depositing rime fog",
        iconRes = R.drawable.cloudly,
        lottieAnimation = R.raw.cloudly_lottie
    )
    object LightDrizzle : WeatherType(
        weatherDesc = "Light drizzle",
        iconRes = R.drawable.rain,
        lottieAnimation = R.raw.rain_lottie
    )
    object ModerateDrizzle : WeatherType(
        weatherDesc = "Moderate drizzle",
        iconRes = R.drawable.rain,
        lottieAnimation = R.raw.rain_lottie
    )
    object DenseDrizzle : WeatherType(
        weatherDesc = "Dense drizzle",
        iconRes = R.drawable.rain,
        lottieAnimation = R.raw.rain_lottie
    )
    object LightFreezingDrizzle : WeatherType(
        weatherDesc = "Slight freezing drizzle",
        iconRes = R.drawable.rain,
        lottieAnimation = R.raw.rain_lottie
    )
    object DenseFreezingDrizzle : WeatherType(
        weatherDesc = "Dense freezing drizzle",
        iconRes = R.drawable.rain,
        lottieAnimation = R.raw.rain_lottie
    )
    object SlightRain : WeatherType(
        weatherDesc = "Slight rain",
        iconRes = R.drawable.rain,
        lottieAnimation = R.raw.rain_lottie
    )
    object ModerateRain : WeatherType(
        weatherDesc = "Rainy",
        iconRes = R.drawable.rain,
        lottieAnimation = R.raw.rain_lottie
    )
    object HeavyRain : WeatherType(
        weatherDesc = "Heavy rain",
        iconRes = R.drawable.rain,
        lottieAnimation = R.raw.rain_lottie
    )
    object HeavyFreezingRain: WeatherType(
        weatherDesc = "Heavy freezing rain",
        iconRes = R.drawable.rain,
        lottieAnimation = R.raw.rain_lottie
    )
    object SlightSnowFall: WeatherType(
        weatherDesc = "Slight snow fall",
        iconRes = R.drawable.snowy,
        lottieAnimation = R.raw.snowy_lottie
    )
    object ModerateSnowFall: WeatherType(
        weatherDesc = "Moderate snow fall",
        iconRes = R.drawable.snowy,
        lottieAnimation = R.raw.snowy_lottie
    )
    object HeavySnowFall: WeatherType(
        weatherDesc = "Heavy snow fall",
        iconRes = R.drawable.snowy,
        lottieAnimation = R.raw.snowy_lottie
    )
    object SnowGrains: WeatherType(
        weatherDesc = "Snow grains",
        iconRes = R.drawable.snowy,
        lottieAnimation = R.raw.snowy_lottie
    )
    object SlightRainShowers: WeatherType(
        weatherDesc = "Slight rain showers",
        iconRes = R.drawable.rain,
        lottieAnimation = R.raw.rain_lottie
    )
    object ModerateRainShowers: WeatherType(
        weatherDesc = "Moderate rain showers",
        iconRes = R.drawable.rain,
        lottieAnimation = R.raw.rain_lottie
    )
    object ViolentRainShowers: WeatherType(
        weatherDesc = "Violent rain showers",
        iconRes = R.drawable.rain,
        lottieAnimation = R.raw.rain_lottie
    )
    object SlightSnowShowers: WeatherType(
        weatherDesc = "Light snow showers",
        iconRes = R.drawable.snowy,
        lottieAnimation = R.raw.snowy_lottie
    )
    object HeavySnowShowers: WeatherType(
        weatherDesc = "Heavy snow showers",
        iconRes = R.drawable.snowy,
        lottieAnimation = R.raw.snowy_lottie
    )
    object ModerateThunderstorm: WeatherType(
        weatherDesc = "Moderate thunderstorm",
        iconRes = R.drawable.storm,
        lottieAnimation = R.raw.storm_lottie
    )
    object SlightHailThunderstorm: WeatherType(
        weatherDesc = "Thunderstorm with slight hail",
        iconRes = R.drawable.storm,
        lottieAnimation = R.raw.storm_lottie
    )
    object HeavyHailThunderstorm: WeatherType(
        weatherDesc = "Thunderstorm with heavy hail",
        iconRes = R.drawable.storm,
        lottieAnimation = R.raw.storm_lottie
    )

    companion object {
        fun fromWMO(code: Int): WeatherType {
            return when(code) {
                0 -> ClearSky
                1 -> MainlyClear
                2 -> PartlyCloudy
                3 -> Overcast
                45 -> Foggy
                48 -> DepositingRimeFog
                51 -> LightDrizzle
                53 -> ModerateDrizzle
                55 -> DenseDrizzle
                56 -> LightFreezingDrizzle
                57 -> DenseFreezingDrizzle
                61 -> SlightRain
                63 -> ModerateRain
                65 -> HeavyRain
                66 -> LightFreezingDrizzle
                67 -> HeavyFreezingRain
                71 -> SlightSnowFall
                73 -> ModerateSnowFall
                75 -> HeavySnowFall
                77 -> SnowGrains
                80 -> SlightRainShowers
                81 -> ModerateRainShowers
                82 -> ViolentRainShowers
                85 -> SlightSnowShowers
                86 -> HeavySnowShowers
                95 -> ModerateThunderstorm
                96 -> SlightHailThunderstorm
                99 -> HeavyHailThunderstorm
                else -> ClearSky
            }
        }
    }
}