package com.example.dentistryapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.dentistryapplication.composables.DrawerBody
import com.example.dentistryapplication.composables.NavHost
import com.example.dentistryapplication.composables.TopBar
import com.example.dentistryapplication.data.drawerScreens
import com.example.dentistryapplication.ui.theme.DentistryApplicationTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DrawerNavigationScreen()
        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DrawerNavigationScreen() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(
                titleResId = R.string.app_name,
                openDrawer =
                {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerGesturesEnabled = true,
        drawerContent = {
            DrawerBody(
                menuItems = drawerScreens,
                scaffoldState,
                scope
            ) {
                navController.navigate(it.id.name) {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }
        }
    ) {
        NavHost(navController = navController)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DentistryApplicationTheme {
        DrawerNavigationScreen()
    }
}