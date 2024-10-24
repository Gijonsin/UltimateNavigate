package com.example.ultimatenavigate.views

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ultimatenavigate.components.MainButton
import com.example.ultimatenavigate.components.MainIconButton
import com.example.ultimatenavigate.components.TitleBar
import com.example.ultimatenavigate.components.Space

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiscountCalculatorView(navController: NavController) {
    Scaffold(
        topBar = {
            androidx.compose.material3.TopAppBar(
                title = { TitleBar(name = "Discount Calculator") },
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
        Greeting(navController)
    }
}


@Composable
fun Greeting(navController: NavController) {
    val context = LocalContext.current
    var precio by remember { mutableStateOf("") }
    var porcentaje by remember { mutableStateOf("") }
    var descuento by remember { mutableStateOf(0.0) }
    var total by remember { mutableStateOf(0.0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = precio,
            onValueChange = { precio = it },
            label = { Text("Price") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = porcentaje,
            onValueChange = { porcentaje = it },
            label = { Text("% Discount") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        ElevatedButton(
            onClick = {
                try {
                    total = precio.toDouble() - (precio.toDouble() * porcentaje.toDouble() / 100)
                    descuento = precio.toDouble() * (porcentaje.toDouble() / 100)
                } catch (e: NumberFormatException) {
                    Toast.makeText(context, "Por favor ingrese valores válidos", Toast.LENGTH_SHORT)
                        .show()
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Calculate")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                precio = ""
                porcentaje = ""
                descuento = 0.0
                total = 0.0
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Clean")
        }
        Text(
            text = "Discount: $descuento",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = "Total: $total",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Space()
        MainButton(
            name = "Lottery Game",
            backColor = MaterialTheme.colorScheme.primary,
            color = MaterialTheme.colorScheme.onPrimary
        ) {
            navController.navigate("Lottery")
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