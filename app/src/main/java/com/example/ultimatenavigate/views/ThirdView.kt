package com.example.ultimatenavigate.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ultimatenavigate.components.MainButton
import com.example.ultimatenavigate.components.MainIconButton
import com.example.ultimatenavigate.components.Space
import com.example.ultimatenavigate.components.TitleBar
import com.example.ultimatenavigate.components.TitleView

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ThirdView(navController: NavController, opcional: String?) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "Third View") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Green
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    ) {
        ContentThirdView(navController, opcional)
    }
}

@Composable
fun ContentThirdView(navController: NavController, opcional: String?) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "Third View")
        Space()
        TitleView(name = opcional.orEmpty())
        MainButton(name = "Return home", backColor = Color.Green, color = Color.White) {
            navController.popBackStack()
        }
    }
}