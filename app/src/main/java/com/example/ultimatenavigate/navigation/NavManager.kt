package com.example.ultimatenavigate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ultimatenavigate.viewModels.LoteriaViewModel
import com.example.ultimatenavigate.views.DogYearsView
import com.example.ultimatenavigate.views.HomeView
import com.example.ultimatenavigate.views.DetailView
import com.example.ultimatenavigate.views.DiscountCalculatorView
import com.example.ultimatenavigate.views.LoteriaView
import com.example.ultimatenavigate.views.ThirdView

@Composable
fun NavManager() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") {
            HomeView(navController)
        }
        composable(
            "Detail/{id}/?{opcional}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType },
                navArgument("opcional") { type = NavType.StringType },
            )
        ) {
            val id = it.arguments?.getInt("id") ?: 0
            val opcional = it.arguments?.getString("opcional") ?: ""
            DetailView(navController, id, opcional)
        }
        composable(
            "Third/{opcional}",
            arguments = listOf(
                navArgument("opcional") { type = NavType.StringType },
            )
        ) {
            val opcional = it.arguments?.getString("opcional") ?: ""
            ThirdView(navController, opcional)
        }
        composable("DogYears") {
            DogYearsView(navController)
        }
        composable("DiscountCalculator"){
            DiscountCalculatorView(navController)
        }
        composable("Lottery"){
            LoteriaView(navController,LoteriaViewModel())
        }
    }
}