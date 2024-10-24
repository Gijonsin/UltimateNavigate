package com.example.ultimatenavigate.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.ultimatenavigate.components.ActionButton
import com.example.ultimatenavigate.components.MainButton
import com.example.ultimatenavigate.components.Space
import com.example.ultimatenavigate.components.TitleBar
import com.example.ultimatenavigate.components.TitleView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar(name = "Home View") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Red
                )
            )
        },
        floatingActionButton = {
            ActionButton()
        }
    ) {
        ContentHomeView(navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentHomeView(navController: NavController) {
    val id = 123
    var opcional by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "Home View")
        Space()

        MainButton(name = "Detail view", backColor = Color.Red, color = Color.White) {
            navController.navigate("Detail/${id}/?${opcional}")
        }
        Space()
        MainButton(name = "Dog Years ", backColor = Color.Red, color = Color.White) {
            navController.navigate("DogYears")

        }
        Space()
        MainButton(name = "Discount Calculator", backColor = Color.Red, color = Color.White) {
            navController.navigate("DiscountCalculator")
        }
        Space()
        MainButton(name = "Lottery Game", backColor = Color.Red, color = Color.White) {
            navController.navigate("Lottery")
        }
    }
}