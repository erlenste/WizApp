package no.erlenste.wizapp.data.models.wizard

import kotlinx.serialization.Serializable

@Serializable
data class WizardElixirDto(
    val id: String,
    val name: String
)
