package com.example.weather.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.weather.R
import com.example.weather.presentation.WeatherState
import kotlin.math.roundToInt

//ui для поточної погоди
@Composable
fun CurrentForecast(
    state: WeatherState
) {
    state.weatherInfo?.currentWeatherData?.let { data ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp)
        ) {
            val composition by rememberLottieComposition(
                spec = LottieCompositionSpec.RawRes(
                    resId = data.weatherType.lottieAnimation
                )
            )
            LottieAnimation(
                composition = composition,
                iterations = LottieConstants.IterateForever,
                modifier = Modifier.size(150.dp)
            )
            Text(
                text = "${data.temperatureCelsius}°",
                color = Color.White,
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = data.weatherType.weatherDesc,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Light
            )
            Text(
                text = "Real feel: ${data.realFeel}°",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Light
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                WeatherDetail(R.drawable.humidity, "${data.humidity.roundToInt()}%")
                WeatherDetail(R.drawable.weather, "${data.precipitation}%")
                WeatherDetail(R.drawable.air, "${data.windSpeed} Km/h")
                WeatherDetail(R.drawable.pressure, "${data.pressure} mBar")
                WeatherDetail(R.drawable.summer, "${data.uvIndex}")
            }
        }
    }
}

@Composable
fun WeatherDetail(iconRes: Int, detail: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(24.dp)
                .padding(1.dp)
        )
        Text(
            text = detail,
            color = Color.White,
            fontSize = 12.sp
        )
    }
}
