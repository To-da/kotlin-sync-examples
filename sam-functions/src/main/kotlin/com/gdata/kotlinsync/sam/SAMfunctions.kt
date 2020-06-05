package com.gdata.kotlinsync.sam

import com.gdata.kotlinsync.sam.ConsumerHandler
import java.util.function.Consumer

/**
 * SAM (single abstract method) conversion
 * See "SAM conversion for Kotlin functions and interfaces" section in
 * https://blog.jetbrains.com/kotlin/2020/03/kotlin-1-4-m1-released/
 */

/**
 * Now, SAM conversion is not supported for pure Kotlin interfaces
 */
interface Action { fun run() }
fun runAction(a: Action) = a.run()
fun samKotlin() {
  //  runAction { println("Hello world!") }       // ERROR: () -> Unit != Action
}

/**
 * From Kotlin 1.4, we can define Kotlin fun interfaces
 */
fun interface FIAction { fun run() }
fun runFIAction(a: FIAction) = a.run()
fun samKotlin14() {
    runFIAction { println("Hello world!") }     // SUCCESS
}

/**
 * Now, SAM conversion already works with Java functional interfaces
 */
fun main() {
    val handler = ConsumerHandler<String>()
    val stringConsumerLambda = { str: String -> println("FI lambda. $str") }
    val stringConsumerObject = object : Consumer<String> {
        override fun accept(str: String) {
            println("FI object. $str")
        }
    }

    handler.registerConsumer(stringConsumerLambda)
    handler.registerConsumer(stringConsumerObject)
 //   handler.registerConsumerRaw(stringConsumerLambda)                           // ERROR: String vs. expected Any param
    handler.registerTwoConsumers(stringConsumerLambda, stringConsumerLambda)
    handler.registerTwoConsumers(stringConsumerObject, stringConsumerObject)
    handler.registerTwoConsumers(stringConsumerLambda, stringConsumerObject)    // ERROR: Lambda vs. expected Consumer param
    // SUCCESS from Kotlin 1.4
    handler.handle("Hello world!")
}