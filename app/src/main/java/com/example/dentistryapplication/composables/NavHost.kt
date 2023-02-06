package com.example.dentistryapplication.composables

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dentistryapplication.R
import com.example.dentistryapplication.data.ScreensRoute


@Composable
fun NavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ScreensRoute.SCREEN_1.name
    ) {
        composable(ScreensRoute.SCREEN_1.name) {
            ScreenContent(R.string.screen_1)
        }
        composable(ScreensRoute.SCREEN_2.name) {
            ScreenContent(R.string.screen_2)
        }
        composable(ScreensRoute.SCREEN_3.name) {
            ScreenContent(R.string.screen_3)
        }
    }
}