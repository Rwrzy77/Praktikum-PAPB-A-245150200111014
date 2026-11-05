package com.example.praktikum4_lifecycle_reasoning_245150200111014_razydeaverroes

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.praktikum4_lifecycle_reasoning_245150200111014_razydeaverroes.ui.theme.Praktikum4_Lifecycle_Reasoning_245150200111014_RazyDeAverroesTheme

data class Student(
    val name: String?,
    val score: Int
) {
    fun getGrade(): String {
        return when {
            score >= 80 -> "A"
            score >= 70 -> "B"
            score >= 60 -> "C"
            else -> "D"
        }
    }
}
class MainActivity : ComponentActivity() {
    private val TAG = "LifecycleReasoning"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate() dipanggil")
        enableEdgeToEdge()
        val student = Student(name = "Razy De Averroes", score = 88)

        val teksHasil = formatTeksStudent(student)
        setContent {
            Praktikum4_Lifecycle_Reasoning_245150200111014_RazyDeAverroesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Text(
                        text = teksHasil,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
    private fun formatTeksStudent(student: Student): String {
        val namaLengkap = student.name ?: "Guest"
        return "Data Mahasiswa:\n" +
                "Nama  : $namaLengkap\n" +
                "Nilai : ${student.score}\n" +
                "Grade : ${student.getGrade()}"
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() dipanggil")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() dipanggil")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() dipanggil")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() dipanggil")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() dipanggil")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart() dipanggil")
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
    Praktikum4_Lifecycle_Reasoning_245150200111014_RazyDeAverroesTheme {
        Greeting("Android")
    }
}