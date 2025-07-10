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

fun main(args: Array<String>) {
    println("Hello World!")
    var ourFirstVariable = true

    println(ourFirstVariable)

    ourFirstVariable = false
    println(ourFirstVariable)

    println(ourFirstVariable == true)
    println(ourFirstVariable == false)

    val aInt: Int = 0
    val anotherInt = 0

    val aByte: Byte = 0
    val aShort: Short = 0

    val aLong: Long = 0
    val inferredInt = 10
    val inferredLong = 10000000000

    val anotherLong = 10L

    val unsignedInt: UInt = 0U
    val unsignedLong = 0UL

    val aDouble: Double = 5.5
    val aFloat: Float = 5.5f

    val inferredDouble = 5.5
    val inferredFloat = 5.5f

    println(5 == 4)
    println(10f > 1)
    println(10.1 <= 5.2)

    println(10.5.toInt())
    10.9.toFloat()
    5.toULong()

    println(100_000_000.toByte())
    val aChar: Char = 'a'
    val aNumericChar = '1'
    val newLineChar = '\n'

    //val concatOption1 = 'a' + 'b'

    //val concatOption2 = 'ab'

    val aString: String = "Hello Kotlin!"
    val escaped = "Hello \n World"
    println(escaped)

    val raw = """
      >>Some
        multiline
     text
      >>is going on
       here   
    """.trimMargin(">>")
    println(raw)

    val concatString = "Hello" + " Kotlin!"

    val concatNumber = "The number " + 10
    println(concatNumber)


    val aNumber = 10
    val concatTemplate = "The number ${1 + aNumber}"
    println(concatTemplate)


    val someString = "  "
    println(someString.isNotBlank())

    val anotherString = "Hello Kotlin World!"
    anotherString.contains("Kotlin")

    var aNullableString: String? = "Kotlin"
    println(aNullableString?.length ?: "the value was null")
}