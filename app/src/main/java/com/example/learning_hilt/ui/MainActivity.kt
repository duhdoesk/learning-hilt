package com.example.learning_hilt.ui

import android.content.res.Configuration
import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learning_hilt.R
import com.example.learning_hilt.ui.theme.ComposeTutorialTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetCar()
        }
    }

    @Composable
    private fun SetCar() {
        val car = viewModel.car!!

        ComposeTutorialTheme() {
            Surface() {
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = "RANDOM CAR GENERATOR",
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = MaterialTheme.colors.primary,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )

                    CardFactory(
                        painter = R.drawable.ic_baseline_directions_car_24,
                        contentDescription = "Car Vector",
                        text = "This is my car!")

                    CardFactory(
                        painter = R.drawable.ic_myengine,
                        contentDescription = "Engine Vector",
                        text = "It has a ${car.engine.power}hp engine...")

                    CardFactory(
                        painter = R.drawable.ic_mywheel,
                        contentDescription = "Wheel Vector",
                        text = """And ${car.wheel.rim}" ${car.wheel.color.name} colored wheels!""")

                    Row(modifier = Modifier
                        .align(CenterHorizontally)) {
                        Button(
                            onClick = { viewModel.setCurrentCar() },
                            modifier = Modifier
                                .padding(16.dp, 40.dp)
                                .size(200.dp, 40.dp)
                        ) {
                            Text(text = "BRAND NEW CAR")
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun CardFactory(painter: Int, contentDescription: String, text: String) {
        Card(
            elevation = 8.dp,
            modifier = Modifier
                .wrapContentSize()
                .padding(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = painter),
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colors.primary),
                    contentDescription = contentDescription,
                    modifier = Modifier
                        .size(120.dp, 80.dp),
                    alignment = Center
                )
                Text(
                    text = text,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Gray
                )
            }
        }
    }
}
