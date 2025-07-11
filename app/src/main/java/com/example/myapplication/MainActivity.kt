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


// Prompt the user to enter the name of the test scores file
// Read each line from the file
// Sort the scores from highest to lowest
// Pick the 3 highest scores
// Write those 3 userId/score pairs to a new file sorted.txt

@RequiresApi(Build.VERSION_CODES.O)
fun main() {

    // enter file name
    print("Enter a filename: ")
    val filename = readLine() ?: ""


    // make sure file name is valid
    val isValidFile = File(filename).isFile
    if (isValidFile) {
        println("It is a valid file")
    } else {
        println("It is not a valid file")
    }

    // Read each line from file
    val scoresFile = File("scores.txt")
    scoresFile.forEachLine { line -> println(line) }
    val rawScores = scoresFile.readLines()

    // sort scores from highest to lowest
    val sortedLines = rawScores.map { line -> //turning scores into a map
        val elements = line.split(":") // telling code where to split elements
        elements[0] to elements[1]  // mapping key value pairs
    }


    // pick 3 highest scores
    val highScores = sortedLines
        .sortedByDescending { pair -> pair.second } //sorting the highest scores to top of list
        .take(n = 3) // taking first three

    //write scores to new file
    val outputFile = File("sorted.txt").toPath() // making new file
    val outputScores = highScores.map{ // turning highscores into a map called output scores
        "${it.first}:${it.second}" // converting it to strings in the original file format
    }
    outputFile.writeLines(outputScores) // writing he lines to the file
}