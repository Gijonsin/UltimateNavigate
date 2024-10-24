package com.example.ultimatenavigate.views

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavController
import com.example.ultimatenavigate.R
import com.example.ultimatenavigate.components.MainButton
import com.example.ultimatenavigate.components.MainIconButton
import com.example.ultimatenavigate.components.TitleBar
import com.example.ultimatenavigate.components.Space

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DogYearsView(navController: NavController) {
    Scaffold(
        topBar = {
            androidx.compose.material3.TopAppBar(
                title = { TitleBar(name = "Años Perrunos") },
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
        PosicionPantalla(navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PosicionPantalla(navController: NavController) {
    val context = LocalContext.current
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var edad by remember { mutableStateOf("") }
        var resultado by remember { mutableStateOf("") }

        Image(
            painter = painterResource(id = R.drawable.mestiso),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            alignment = Alignment.Center
        )
        Text(
            text = "Mis Años Perrunos",
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive
        )
        OutlinedTextField(
            value = edad,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            onValueChange = {
                if (it.isDigitsOnly()) {
                    edad = it
                } else if (it.equals("")) {
                    Toast.makeText(context, "Por favor ingrese su edad", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Favor de solo usar números", Toast.LENGTH_SHORT).show()
                }
            },
            label = { Text("Mi edad humana") }
        )
        ElevatedButton(
            onClick = {
                var res = 0
                res = edad.toInt() * 7
                resultado = res.toString()
            }
        ) {
            Text("Calcular")
        }
        OutlinedTextField(
            value = resultado,
            readOnly = true,
            onValueChange = { resultado = it },
            label = { Text("Edad Perruna") }
        )
        ElevatedButton(
            onClick = {
                edad = ""
                resultado = ""
            }
        ) {
            Text("Limpiar")
        }
        Space()
        MainButton(
            name = "Discount Calculator",
            backColor = MaterialTheme.colorScheme.primary,
            color = MaterialTheme.colorScheme.onPrimary
        ) {
            navController.navigate("DiscountCalculator")
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