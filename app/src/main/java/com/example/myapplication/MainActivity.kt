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

private fun printGreeting() = println("Hello Kotlin")
fun printCalculatedValue(value1: Int, value2: Int, calculator: (Int, Int) -> Int) {
    println("The value is: ${calculator(value1, value2)}")
}
fun main() {
    fun getGreeting(
        greeting: String = "Hello",
        thingToGreet: String = "World"
    ) = "$greeting $thingToGreet"

    println(getGreeting(thingToGreet = "World", greeting = "Hey there"))
    printCalculatedValue(2, 2) { value1, value2 ->
        value1 + value2
    }

    printCalculatedValue(2, 2, { value1, value2 ->
        value1 - value2
    })
}