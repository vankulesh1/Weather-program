package com.example.weather.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.domain.weather.WeatherData
import com.example.weather.presentation.WeatherState
import kotlinx.coroutines.delay
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt


//ui для погодинного відображення погоди
@Composable
fun HourlyForecast(state: WeatherState) {
    state.weatherInfo?.weatherDataPerDay?.get(0).let {data ->
        if(state.isLoading) {
            LaunchedEffect(key1 = state) {
                delay(50000)
            }
        } else {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF1565C0)
                )
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                    text = "Hourly forecast",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                    Spacer(modifier = Modifier.height(8.dp))
                    LazyRow {
                        items(data.orEmpty()) { item: WeatherData ->
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(20.dp)
                            ) {
                                Text(
                                    text = "${item.temperatureCelsius.roundToInt()}°",
                                    color = Color.White,
                                    fontSize = 14.sp
                                )
                                Image(
                                    painter = painterResource(id = item.weatherType.iconRes),
                                    contentDescription = null,
                                    modifier = Modifier.size(32.dp)
                                )
                                Text(
                                    text = item.time.format(
                                        DateTimeFormatter.ofPattern("HH:mm")
                                    ),
                                    color = Color.White,
                                    fontSize = 12.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
