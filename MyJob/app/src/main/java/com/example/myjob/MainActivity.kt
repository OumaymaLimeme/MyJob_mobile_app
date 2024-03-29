package com.example.myjob
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
@Preview(showBackground = true)
@Composable
fun App() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login_page",builder= {
        composable("login_page", content = { LoginPage(navController = navController) })
        composable("register_page") { RegisterPage(navController = navController) }
        //  composable("reset_page") { ResetPage(navController = navController) }
    })
}




