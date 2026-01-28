package no.erlenste.wizapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import no.erlenste.wizapp.data.datasource.WizDataSource
import no.erlenste.wizapp.data.models.Option
import no.erlenste.wizapp.data.models.spell.SpellDto
import no.erlenste.wizapp.data.models.wizard.WizardDto
import javax.inject.Inject

@HiltViewModel
class WizViewModel @Inject constructor(
    private val wizDataSource: WizDataSource
) : ViewModel() {

    // TODO: define flows and internal state holders
    private val _uiState = MutableStateFlow<UiState<WizardUiState>>(UiState.Idle)
    val uiState : StateFlow<UiState<WizardUiState>> = _uiState.asStateFlow()


    fun getSpells() {
       viewModelScope.launch {
           _uiState.value = UiState.Loading
           try {
               val spells = wizDataSource.getSpells()
               _uiState.value = UiState.Success(WizardUiState(emptyList(), spells = spells))
           } catch (e: Exception) {
               _uiState.value = UiState.Error
           }
       }
    }

    fun getWizards() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val wizards = wizDataSource.getWizards()
                _uiState.value = UiState.Success(WizardUiState(wizards = wizards, emptyList()))
            } catch (e: Exception) {
                _uiState.value = UiState.Error
            }
        }
    }

    fun handleOptionSelected(it: Option) {
        when (it) {
            Option.SPELLS -> getSpells()
            Option.WIZARDS -> getWizards()
        }
    }


    // TODO: add functionality to fetch spells and wizards

    // TODO: implement the WizUiState
    // TODO: implement the UiState
}

data class WizardUiState(val wizards: List<WizardDto>, val spells: List<SpellDto>)

sealed class UiState <out T> {
    object Idle : UiState<Nothing>()
    object Error : UiState<Nothing>()
    object Loading : UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
}