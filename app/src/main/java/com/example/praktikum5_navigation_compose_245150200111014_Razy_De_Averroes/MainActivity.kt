package com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.navigation.NavigationLabApp
import com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.ui.theme.Praktikum5_Navigation_Compose_Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Praktikum5_Navigation_Compose_Theme() {
                Surface(modifier = Modifier.fillMaxSize()) {
                    NavigationLabApp()
                }
            }
        }
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Praktikum5_Navigation_Compose_Theme {
        Greeting("Android")
    }
}