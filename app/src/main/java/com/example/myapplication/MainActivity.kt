package com.example.myapplication

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

import java.io.File
import kotlin.io.path.writeLines

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


fun main1(vararg args: String) {

    if (args.isEmpty()) {
        print("Please pass at least one argument")
        return
    }

    println("First arg is ${args[0]}")

    for (arg in args) println(arg)
}

fun main2() {
    print("Enter a filename: ")
    val filename = readLine() ?: ""
    println("You entered: $filename")

    val isValidFile = File(filename).isFile
    if (isValidFile) {
        println("It is a valid file")
    } else {
        println("It is not a valid file")
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun main() {
    val scoresFile = File("scores.txt")

    scoresFile.forEachLine { line -> println(line) }

    val sortedLines = scoresFile.readLines().sorted()

    val outputFile = File("sorted-scores.txt").toPath()
    outputFile.writeLines(sortedLines)
}