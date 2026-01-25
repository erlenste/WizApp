package no.erlenste.wizapp.data.models.wizard

import kotlinx.serialization.Serializable

@Serializable
data class WizardDto(
    val elixirs: List<WizardElixirDto>,
    val id: String,
    val firstName: String?,
    val lastName: String?
) {
    fun getFullName(): String {
        return listOfNotNull(firstName, lastName).joinToString(" ")
    }
}