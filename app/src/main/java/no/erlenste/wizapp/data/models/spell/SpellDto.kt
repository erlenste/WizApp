package no.erlenste.wizapp.data.models.spell

import kotlinx.serialization.Serializable

@Serializable
data class SpellDto(
    val id: String?,
    val name: String?,
    val incantation: String?,
    val effect: String?,
    val canBeVerbal: Boolean?,
    val type: SpellType?,
    val light: SpellLight?,
    val creator: String?
)