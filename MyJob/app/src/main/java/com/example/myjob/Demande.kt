package com.example.myjob

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.jodatime.date
import org.joda.time.DateTime

class Demande(
    var demandeId: Int,
    var date: DateTime,
    var statut: String,
    var cv: Byte,
    var candidateId: Int,
    var offreId: Int
)

object Demandes : IntIdTable() {
    val candidate = reference("candidate_id", Candidates, onDelete = ReferenceOption.CASCADE)
    val offre = reference("offre_id", Offres, onDelete = ReferenceOption.CASCADE)
    val demandeId = integer("demandeId")
    val Date = date("date")
    val Statut = varchar("Statut", 50)
    val CV = byte("CV")

    // Map the table columns to the User entity
    fun toDemande(row: ResultRow): Demande {
        return Demande(
            row[Demandes.demandeId],
            row[Demandes.Date],
            row[Demandes.Statut],
            row[Demandes.CV],
            row[candidate].value,
            row[offre].value
        )
    }
}
