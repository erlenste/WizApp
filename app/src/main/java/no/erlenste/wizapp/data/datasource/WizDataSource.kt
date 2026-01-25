package no.erlenste.wizapp.data.datasource

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import no.erlenste.wizapp.data.models.spell.SpellDto
import no.erlenste.wizapp.data.models.wizard.WizardDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WizDataSource @Inject constructor(
    private val httpClient: HttpClient
) {

    private val baseUrl = "https://wizard-world-api.herokuapp.com"

    //https://wizard-world-api.herokuapp.com/swagger/index.html

    //https://wizard-world-api.herokuapp.com/Spells
    //https://wizard-world-api.herokuapp.com/Wizards

    suspend fun getSpells(): List<SpellDto> {
        val response: HttpResponse = httpClient.get("${baseUrl}/Spells")
        if (response.status.value != 200) {
            throw Exception("Failed to get spells")
        }
        return response.body()
    }

    suspend fun getWizards(): List<WizardDto> {
        val response: HttpResponse = httpClient.get("${baseUrl}/Wizards")
        if (response.status.value != 200) {
            throw Exception("Failed to get wizards")
        }
        return response.body()
    }

}