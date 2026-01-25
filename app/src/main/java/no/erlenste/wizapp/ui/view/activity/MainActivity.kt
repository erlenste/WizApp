package no.erlenste.wizapp.ui.view.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import no.erlenste.wizapp.R
import no.erlenste.wizapp.ui.theme.WizAppTheme
import no.erlenste.wizapp.ui.view.components.AppToolbar

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
    Text(
        text = "This should render OK",
        modifier = modifier
    )
}