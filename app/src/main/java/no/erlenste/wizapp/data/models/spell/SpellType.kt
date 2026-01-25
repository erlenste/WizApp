package no.erlenste.wizapp.data.models.spell

import kotlinx.serialization.Serializable

@Serializable
enum class SpellType {
    None, Charm, Conjuration, Spell, Transfiguration, HealingSpell, DarkCharm, Jinx, Curse, MagicalTransportation, Hex, CounterSpell, DarkArts, CounterJinx, CounterCharm, Untransfiguration, BindingMagicalContract, Vanishment
}