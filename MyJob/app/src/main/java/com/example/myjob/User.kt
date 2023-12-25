import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ResultRow

data class User(
        val id: Int,
        val firstname: String,
        val email: String,
        val lastname: String,
        val age: Int,
        val password: String,
        val phone: Int
)

object Users : IntIdTable() {
    val firstname = varchar("firstname", 50)
    val email = varchar("email", 100)
    val lastname = varchar("lastname", 50)
    val age = integer("age")
    val password = varchar("password", 50)
    val phone = integer("phone")

    // Map the table columns to the User entity
    fun toUser(row: ResultRow): User {
        return User(
                row[Users.id].value,
                row[Users.firstname],
                row[Users.email],
                row[Users.lastname],
                row[Users.age],
                row[Users.password],
                row[Users.phone]
        )
    }
}
