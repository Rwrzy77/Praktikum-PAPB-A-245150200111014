package com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.ui.theme.screen
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.ui.detail.DetailUiState.DetailUiState

@Composable
fun DetailScreen(
    uiState: DetailUiState,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Detail", style = MaterialTheme.typography.headlineMedium)

        when {
            uiState.isLoading -> {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            uiState.errorMessage != null -> {
                Text(uiState.errorMessage)
            }

            uiState.student != null -> {
                val data = uiState.student
                Text(data.name, style = MaterialTheme.typography.headlineSmall)
                Text("Email: ${data.email}")
                Text("University: ${data.university}")
            }
        }

        Button(onClick = onBack) { Text("Kembali") }
    }
}