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

// write a function that satisfies the following requirements

// function takes 2 strings for first and last name
// function takes a formatting function parameter
// function should print the result of the passed format function

fun printFormattedName(firstName: String, lastName: String, nameConcat: (String, String) -> String) {
    println(nameConcat(firstName, lastName))
}
val basicFormatter: (String, String) -> String = { firstName, lastName ->
    "$firstName $lastName"
}

val fancyFormatter: (String, String) -> String = { firstName, lastName ->
    "first name is $firstName and last name is $lastName"
}

fun main() {
    printFormattedName (firstName = "Tay", lastName = "Marier", basicFormatter)
    printFormattedName (firstName = "Tay", lastName = "Marier", fancyFormatter)
    printFormattedName (firstName = "Tay", lastName = "Marier") { firstName, lastName ->
        "My name is $firstName $lastName"
    }

}