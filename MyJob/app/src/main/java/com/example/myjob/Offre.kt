package com.example.myjob
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.ResultRow
class Offre(
    var id: Int,
    var annees_experience: Int,
    var Connaissances: String,
    var Contrat: String,
    var Langues: Int,
    var Mission: String,
    var NbrARecruter: Int,
    var Formation: String,
    var Salaire: Float,
    var Specialite: String,
    var Ville_Travail: String,
    var TachePrincipale: String,
    var recruiterId: Int
)
object Offres : IntIdTable() {
    val recruiter = reference("recruiter_id", Recruiters, onDelete = ReferenceOption.CASCADE)
    val anneesExperience = integer("annees_experience")
    val connaissances = varchar("Connaissances", 255)
    val contrat = varchar("Contrat", 50)
    val langues = integer("Langues")
    val mission = varchar("Mission", 255)
    val nbrARecruter = integer("NbrARecruter")
    val formation = varchar("Formation", 255)
    val salaire = float("Salaire")
    val specialite = varchar("Specialite", 100)
    val villeTravail = varchar("Ville_Travail", 100)
    val tachePrincipale = varchar("TachePrincipale", 255)

    fun toOffre(row: ResultRow): Offre {
        return Offre(
            row[id].value,
            row[anneesExperience],
            row[connaissances],
            row[contrat],
            row[langues],
            row[mission],
            row[nbrARecruter],
            row[formation],
            row[salaire],
            row[specialite],
            row[villeTravail],
            row[tachePrincipale],
            row[recruiter].value
        )
    }
}