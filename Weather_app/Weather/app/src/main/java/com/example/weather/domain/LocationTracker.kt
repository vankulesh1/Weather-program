package com.example.weather.domain

import android.location.Location

//інтерфейс LocationTracker для абстракції
interface LocationTracker {
    suspend fun getCurrentLocation(): Location?
}
