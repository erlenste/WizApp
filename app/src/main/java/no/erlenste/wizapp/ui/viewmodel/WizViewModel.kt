package no.erlenste.wizapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import no.erlenste.wizapp.data.datasource.WizDataSource
import javax.inject.Inject

@HiltViewModel
class WizViewModel @Inject constructor(
    private val wizDataSource: WizDataSource
) : ViewModel() {

    // TODO: define flows and internal state holders

    // TODO: add functionality to fetch spells and wizards

    // TODO: implement the WizUiState
    // TODO: implement the UiState
}