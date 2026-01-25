package no.erlenste.wizapp.ui.view.utils

import no.erlenste.wizapp.data.models.spell.SpellDto
import no.erlenste.wizapp.data.models.spell.SpellLight
import no.erlenste.wizapp.data.models.spell.SpellType
import no.erlenste.wizapp.data.models.wizard.WizardDto
import no.erlenste.wizapp.data.models.wizard.WizardElixirDto

class WizUtils {
    fun getMockSpell(): SpellDto {
        return SpellDto(
            id = "id",
            name = "name",
            incantation = "incantation",
            effect = "effect",
            canBeVerbal = true,
            type = SpellType.CounterSpell,
            light = SpellLight.PsychedelicTransparentWave,
            creator = "creator"
        )
    }

    fun getMockWizard(): WizardDto {
        return WizardDto(
            id = "id",
            firstName = "firstName",
            lastName = "lastName",
            elixirs = listOf(
                WizardElixirDto("id1", "elixir 1"),
                WizardElixirDto("id2", "elixir 2")
            )
        )
    }
}