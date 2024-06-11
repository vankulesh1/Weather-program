package com.example.weather.presentation.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.LineType
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine
import com.example.weather.domain.weather.WeatherData
import com.example.weather.presentation.WeatherState
import androidx.compose.material3.Text
import kotlin.math.roundToInt


@Composable
fun Temp (state: WeatherState) {
    state.weatherInfo?.weatherDataPerDay?.get(0).let { data ->
        val value = mutableListOf<Int>()
        LazyRow {
            items(data.orEmpty()) { item: WeatherData ->
                Text(
                    text = "${item.temperatureCelsius.roundToInt()}°"
                )
                value.add(item.temperatureCelsius.roundToInt())
            }
            value.size
        }
    }

            //TemperatureChart(points = points)
}

@Composable
fun TemperatureChart (points: List<Point>) {
    val steps = 5
    val xAxisData = AxisData.Builder()
        .axisStepSize(20.dp)
        .steps(points.size - 1)
        .backgroundColor(Color(0xFF1565C0))
        .labelData { i -> i.toString() }
        .labelAndAxisLinePadding(15.dp)
        .axisLineColor(Color.White)
        .axisLabelColor(Color.White)
        .build()

    val yAxisData = AxisData.Builder()
        .steps(steps)
        .labelAndAxisLinePadding(20.dp)
        .backgroundColor(Color(0xFF1565C0))
        .labelData { i ->
            val yScale = 100 / steps
            (i * yScale).toString()
        }
        .axisLineColor(Color.White)
        .axisLabelColor(Color.White)
        .build()

    val lineChartData = LineChartData(
        linePlotData = LinePlotData(
            lines = listOf(
                Line(
                    dataPoints = points,
                    LineStyle(
                        color = Color.White,
                        lineType = LineType.SmoothCurve()

                    ),
                    IntersectionPoint(
                        color = Color.White
                    ),
                    SelectionHighlightPoint(
                        color = Color.White
                    ),
                    ShadowUnderLine(
                        alpha = 0.2f
                    ),
                    SelectionHighlightPopUp()
                )
            )
        ),
        backgroundColor = Color(0xFF1565C0),
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        gridLines = null
    )

    Spacer(modifier = Modifier.height(16.dp))
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1565C0)
        )
    ){
        LineChart(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp), lineChartData = lineChartData
        )
    }
}