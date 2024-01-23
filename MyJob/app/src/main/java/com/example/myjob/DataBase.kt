package com.example.myjob

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import java.sql.DriverManager
    fun main() {
        val jdbcUrl = "jdbc:postgresql://localhost:5433/MyJob"
        val connection = DriverManager.getConnection(jdbcUrl, "postgres", "admin")
        Database.connect(url = jdbcUrl, user = "postgres", password = "admin")
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