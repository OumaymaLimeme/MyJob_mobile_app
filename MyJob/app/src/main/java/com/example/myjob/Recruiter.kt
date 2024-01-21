package com.example.myjob

import User
import Users
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ResultRow

class Recruiter (
    id: Int,
    firstname: String,
    email: String,
    lastname: String,
    age: Int,
    password: String,
    phone: Int,
    role: Role,
    var Position: String,
    var Company:String
    ): User(id, firstname, email, lastname, age, password, phone, role)
    object Recruiters : IntIdTable() {
        val user = Candidates.reference("recruiter_id", Users)
        val Position = varchar("position", 50)
        val Company = varchar("company", 50)


        fun toRecruiter(row: ResultRow): Recruiter {
            return Recruiter(
                row[user].value,
                row[Users.firstname],
                row[Users.email],
                row[Users.lastname],
                row[Users.age],
                row[Users.password],
                row[Users.phone],
                row[Users.role],
                row[Position],
                row[Company]
            )
        }
    }