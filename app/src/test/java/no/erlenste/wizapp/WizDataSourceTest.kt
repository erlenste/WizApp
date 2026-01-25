package no.erlenste.wizapp

import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import no.erlenste.wizapp.data.datasource.WizDataSource
import org.junit.Test

class WizDataSourceTest {

    @Test
    fun getSpells() {
        val wizDataSource = WizDataSource()
        runBlocking {
            val spells = wizDataSource.getSpells()
            assertTrue(spells.isNotEmpty())
        }
    }

    @Test
    fun getWizards() {
        val wizDataSource = WizDataSource()
        runBlocking {
            val wizards = wizDataSource.getWizards()
            assertTrue(wizards.isNotEmpty())
        }
    }
}