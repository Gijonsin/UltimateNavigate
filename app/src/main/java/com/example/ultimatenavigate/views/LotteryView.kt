package com.example.ultimatenavigate.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ultimatenavigate.components.MainButton
import com.example.ultimatenavigate.components.MainIconButton
import com.example.ultimatenavigate.components.Space
import com.example.ultimatenavigate.components.TitleBar
import com.example.ultimatenavigate.viewModels.LoteriaViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoteriaView(navController: NavController, viewModel: LoteriaViewModel) {
    val lottonNumbers = viewModel.lotoNumbers.value
    Scaffold(
        topBar = {
            androidx.compose.material3.TopAppBar(
                title = { TitleBar(name = "Lottery") },
                colors = androidx.compose.material3.TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    MainIconButton(icon = androidx.compose.material.icons.Icons.Default.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (lottonNumbers.isEmpty()) {
                Text(
                    text = "Loteria",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
            } else {
                LotteryNumbers(lottonNumbers)
            }
            Button(onClick = { viewModel.generateLotoNumbers() }) {
                Text(
                    text = "Generar",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Space()
            MainButton(
                name = "Return home",
                backColor = MaterialTheme.colorScheme.primary,
                color = MaterialTheme.colorScheme.onPrimary
            ) {
                navController.navigate("Home")
            }
        }
    }
}

@Composable
fun LotteryNumbers(lottonNumbers: List<Int>) {
    LazyRow(
        contentPadding = PaddingValues(
            horizontal = 16.dp,
            vertical = 8.dp
        )
    ) {
        items(lottonNumbers) { number ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(48.dp)
                    .background(Color.Red, CircleShape)
            ) {
                Text(
                    text = number.toString(),
                    color = Color.White,
                    fontSize = 24.sp
                )
            }
        }
    }
}