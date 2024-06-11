package com.example.weather.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.data.mapWeatherData
import com.example.weather.presentation.WeatherState
import java.time.LocalDateTime
import kotlin.math.roundToInt

//ui для прогнозу на 7 днів
@Composable
fun WeeklyForecast(state: WeatherState) {
    state.weatherInfo?.weatherDataPerDay?.let {data ->
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF1565C0)
            )
        ) {
            Column(modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
            ) {
                Text(
                    text = "7-day forecast",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                LazyColumn (modifier = Modifier
                    .fillMaxWidth()
                    .height(392.dp)) {
                    items(mapWeatherData(data)) { items ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp)
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            if (items.date == LocalDateTime.now().dayOfWeek.toString()) {
                                Text(
                                    text = "Today",
                                    color = Color.White,
                                    fontSize = 16.sp,
                                    modifier = Modifier.weight(1f))
                            } else {
                                Text(
                                    text = items.date[0] + items.date.lowercase().drop(1),
                                    color = Color.White,
                                    fontSize = 16.sp,
                                    modifier = Modifier.weight(1f))
                            }
                            Image(
                                painter = painterResource(id = items.weatherCode),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(24.dp)
                                    .weight(1f)
                            )
                            Text(text = "${items.maxTemperature.roundToInt()}°/${items.minTemperature.roundToInt()}°",
                                color = Color.White, fontSize = 16.sp)
                        }
                    }
                }
            }
        }
    }
}