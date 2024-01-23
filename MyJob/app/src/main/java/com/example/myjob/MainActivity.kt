package com.example.myjob
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import java.sql.DriverManager
import com.example.myjob.LoginPage
import com.example.myjob.RegisterPage
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


fun main() {
    val jdbcUrl = "jdbc:postgresql://localhost:5433/MyJob"

    // get the connection
    val connection = DriverManager.getConnection(jdbcUrl, "postgres", "admin")

    // Configure Exposed to use this connection
    Database.connect(url = jdbcUrl, user = "postgres", password = "admin")

    // Create the table using Exposed's SchemaUtils
    try {
        transaction {
            SchemaUtils.create(Candidates)
            SchemaUtils.create(Recruiters)
            SchemaUtils.create(Demandes)
            SchemaUtils.create(Offres)
            commit()
        }
    } catch (e: Exception) {
        println("Error creating tables: ${e.message}")
    }
}

