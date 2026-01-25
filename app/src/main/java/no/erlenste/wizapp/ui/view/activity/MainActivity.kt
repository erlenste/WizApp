package no.erlenste.wizapp.ui.view.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import no.erlenste.wizapp.R
import no.erlenste.wizapp.data.models.Option
import no.erlenste.wizapp.data.models.spell.SpellDto
import no.erlenste.wizapp.data.models.wizard.WizardDto
import no.erlenste.wizapp.data.models.wizard.WizardElixirDto
import no.erlenste.wizapp.ui.theme.WizAppTheme
import no.erlenste.wizapp.ui.view.components.AppToolbar
import no.erlenste.wizapp.ui.view.components.Dropdown
import no.erlenste.wizapp.ui.view.utils.WizUtils

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WizAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { AppToolbar(getString(R.string.app_name)) }
                ) { innerPadding ->
                   MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Dropdown(
            options = listOf(Option.SPELLS, Option.WIZARDS),
            selectedOption = Option.SPELLS,
            onOptionSelected = {}
        )
        Column{
            Text(text = "Render the results here!")
        }
    }
}

@Composable
fun SpellResult(modifier: Modifier = Modifier, spells: List<SpellDto>) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 0.dp
    ) {
        items(spells.size) { index ->
            SpellBox(modifier = modifier, spell = spells[index])
        }
    }
}

@Composable
fun WizardResult(modifier: Modifier = Modifier, wizards: List<WizardDto>) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 0.dp
    ) {
        items(wizards.size) { index ->
            WizardBox(modifier = modifier, wizard = wizards[index])
        }
    }
}

@Composable
fun SpellBox(modifier: Modifier = Modifier, spell: SpellDto) {
    Card(
        modifier = Modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            BoldText(text = spell.name ?: "Ukjent")
            Text(text = spell.effect ?: "Ukjent")
            Text(text = spell.incantation ?: "Ukjent")
        }
    }
}

@Composable
fun WizardBox(modifier: Modifier = Modifier, wizard: WizardDto) {
    Card(
        modifier = Modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            BoldText(text = wizard.getFullName())
            if (wizard.elixirs.isNotEmpty()) {
                Text(text = "Elixirs:")
                wizard.elixirs.forEach {
                    ElixirCard(wizardElixir = it)
                }
            }
        }
    }
}

@Composable
fun ElixirCard(modifier: Modifier = Modifier, wizardElixir: WizardElixirDto) {
    Card(
        modifier = Modifier.padding(4.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = wizardElixir.name)
        }
    }
}

@Composable
fun BoldText(text: String) {
    Text(text = text, fontWeight = FontWeight.SemiBold)
}

@Composable
@Preview(showBackground = true)
fun SpellResultPreview() {
    WizAppTheme {
        SpellResult(
            spells = List(5) { WizUtils().getMockSpell() }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun SpellBoxPreview() {
    WizAppTheme {
        SpellBox(spell = WizUtils().getMockSpell())
    }
}

@Composable
@Preview(showBackground = true)
fun WizardResultPreview() {
    WizAppTheme {
        WizardResult(
            wizards = List(5) { WizUtils().getMockWizard() }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun WizardBoxPreview() {
    WizAppTheme {
        WizardBox(wizard = WizUtils().getMockWizard())
    }
}