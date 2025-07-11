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

// Arrays
    val ints = arrayOf(1, 2, 3, 4, null)

    val nulls = arrayOfNulls<Int>(5)

    val custom = Array(5) { index -> index }

    val sizeOfArray = ints.size

    val firstValue = ints[0]
    ints.set(0, 99)
    ints[0] = 99

    val primitiveInts = intArrayOf(1, 2, 3, 4, 5)
    val primitiveUShorts = ushortArrayOf(1u, 2u, 3u, 4u, 5u)

//    for (i in 0 until ints.size) {
//        println(ints[i])
//    }
//
//    for (element in ints) {
//        println(element)
//    }
//
//    ints.forEach { element -> println(element) }


    greetThings("Hey", arrayOf("Kotlin", "Programming"))
    greetThings("Hello", "Kotlin", "Programming", "LinkedIn")
}

fun greetThings(greeting: String, vararg items: Any) {
    for (item in items) {
        println("$greeting $item")
    }


// Lists
    val stringList: List<String> = listOf("kotlin", "code", "puppy")
    val listOfInt = listOf(1, 2, 3, null)

    val doubledValues = List<Int>(5) { index ->
        2 * index
    }

    doubledValues.forEach { println(it) }

    val emptyStringList: List<String> = emptyList()

    val firstInt = listOfInt.get(0)
    val secondedInt = listOfInt[1]

    val languages = mutableListOf("kotlin", "java")
    languages[0] = "Kotlin"
    languages.set(0, "Kotlin")

    languages.add("javascript")
    languages.add(1, "c++")
    languages.remove("javascript")
    languages.removeAt(0)

    val aList: List<String> = mutableListOf("dog", "cat")

// Sets and Maps
    val languages1 = mutableSetOf("kotlin", "java", "c++", "kotlin")
    for (language in languages1) {
        println(language)
    }
    languages1.size
    println(languages1.contains("kotlin"))

    languages1.add("javascript")
    languages1.remove("javascript")

    val testScores = mutableMapOf(Pair(123, 91.2), Pair(456, 84.5), 789 to 79.1)
    println(testScores[123])

    for ((id, score) in testScores) {
        println("score for user ${id} was ${score}")
    }

    testScores.containsKey(123)
    testScores.containsValue(100.0)

    testScores.keys.forEach { println(it) }

    testScores[111] = 97.8
    testScores.put(222, 72.1)
    testScores.remove(222)
    testScores.replace(111, 98.7)

// Collections
    val readOnlyList = listOf(1, 2, 3)
    val readOnlySet = setOf(1, 2, 3)
    val readOnlyMap = mapOf(1 to "a", 2 to "b")

    val mutableList = mutableListOf(1, 2, 3)
    val mutableSet = mutableSetOf(1, 2, 3)
    val mutableMap = mutableMapOf(1 to "a", 2 to "b")

    mutableList.size
    readOnlyMap.size

    mutableSet.isEmpty()
    readOnlyList.isNotEmpty()

    for (element in readOnlySet) {
        println(element)
    }

    mutableMap.forEach { key, value -> println(value) }

    readOnlyList.first()
    mutableSet.first()

    mutableList.take(3)
    readOnlySet.take(2)

    mutableMap.filter { entry -> entry.key < 2 }
    readOnlyList.filter { value -> value > 1 }

    val languages2 = mapOf(
        "kotlin" to 5,
        "java" to 3,
        "javascript" to 4,
        "c++" to 2,
        "python" to 6
    )

    languages2.filter { it.value >= 4 }
        .map { it.key }
        .sorted()
        .forEach { println(it) }


// Sequences
    val languages3 = listOf("kotlin", "c++", "java")
        .filter { it.length > 4 }
        .map { it.length }

    val languageSequence = sequenceOf("kotlin", "c++", "java")

    val fromIterable = listOf(1, 2, 3).asSequence()

    languageSequence.filter { it.length > 4 }.map { it.length }.take(2)
}