import com.example.myjob.Role
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ResultRow
open class User(
    var id: Int,
    val firstname: String,
    val email: String,
    val lastname: String,
    val age: Int,
    val password: String,
    val phone: Int,
    val role:Role
)

object Users : IntIdTable() {
    val firstname = varchar("firstname", 50)
    val email = varchar("email", 100)
    val lastname = varchar("lastname", 50)
    val age = integer("age")
    val password = varchar("password", 50)
    val phone = integer("phone")
    val role = enumerationByName("role", 50, Role::class)

}

