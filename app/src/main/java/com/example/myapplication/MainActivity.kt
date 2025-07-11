package com.example.myapplication

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
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
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
    MyApplicationTheme {
        Greeting("Android")
    }
}


fun main() {

    val testScores = mapOf(
        "123abc" to 88.1,
        "124xyz" to 88.9,
        "345abc" to 82.1,
        "345bbc" to 72.1,
        "34efbc" to 66.1,
        "345abc" to 89.1,
        "385agc" to 62.1,
        "837abc" to 85.7,
        "9459bc" to 94.3,
        "nd2192" to 83.8,
    )

    // Using the provided test scores, identify the 3 students
    // with the lowest test scores
    testScores.toList()
        .sortedBy { pair -> pair.second }
        .map { pair -> pair.first }
        .take(n = 3)
    .forEach { println(it) }

    testScores.filter { it.value <= 75 }
        .map { it.key }
        .sorted()
        .forEach { println(it) }

}