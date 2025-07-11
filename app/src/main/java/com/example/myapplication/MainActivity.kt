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

fun getMessage(input: Int) = if (input > 3) {
    "Greater than 3"
} else {
    "Not greater than 3"
}

fun getMessageWithWhen(input: Int) = when (input) {
    3 -> "Value is 3"
    else -> "Value is not 3"
}

fun checkType(input: Any?) {
    when (input) {
        null -> println("Input was null")
        is String -> println("Input was a String of length ${input.length}")
    }
}

fun main() {
    var someVariable = 100

//    when {
//        someVariable > 3 -> println("The value was greater than 3")
//        someVariable > 2 -> println("The value was greater than 2")
//        else -> {
//            println("Not greater")
//        }
//    }

    when (someVariable) {
        0,1 -> println("The value was 0 or 1")
        2 -> println("The value is 2")
        3 -> println("The value is 3")
        in 4..Int.MAX_VALUE -> println("The value was greater than 3")
    }
    var anotherVariable = 0

    val message = when (anotherVariable) {
        3 -> "The value is 3"
        else -> "The value is not 3"
    }

    val anothermessage = try {
        throw IllegalStateException()
        "The value is ${10 / 0}"
    } catch (error: ArithmeticException) {
        "Error was thrown"
    } catch (error: java.lang.IllegalStateException) {
        "Error was IllegalState"
    }
    println(anothermessage)

    val aGenericVariable: Any = 5

    checkType("null")

    var counter = 0

    do {
        println(counter)
        counter += 1
    } while (counter < 5)

    for (i in 10 downTo 0 step 3) println(i)
}