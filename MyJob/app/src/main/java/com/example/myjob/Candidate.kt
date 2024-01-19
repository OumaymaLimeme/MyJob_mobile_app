package com.example.myjob

import User
import Users
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ResultRow

class Candidate(
    id: Int,
    firstname: String,
    email: String,
    lastname: String,
    age: Int,
    password: String,
    phone: Int,
    role: Role,
    var Diploma: String,
    var NbrYearsExperience: Int
) : User(id, firstname, email, lastname, age, password, phone, role)

object Candidates : IntIdTable() {
    val user = reference("candidate_id", Users)
    val diploma = varchar("diploma", 50)
    val nbrYearsExperience = integer("nbryearsexperience")

    // Map the table columns to the Candidate entity
    fun toCandidate(row: ResultRow): Candidate {
        return Candidate(
            row[user].value,
            row[Users.firstname],
            row[Users.email],
            row[Users.lastname],
            row[Users.age],
            row[Users.password],
            row[Users.phone],
            row[Users.role],
            row[diploma],
            row[nbrYearsExperience]
        )
    }
}