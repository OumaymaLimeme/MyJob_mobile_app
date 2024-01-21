package com.example.myjob

import Users
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myjob.ui.theme.MyJobTheme
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import java.sql.DriverManager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyJobTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyJobTheme {
        Greeting("Android")
    }
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