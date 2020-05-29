package com.gdata.kotlinsync.restapi.sync2

import com.gdata.kotlinsync.library.SomeClass

/**
 * Kotlin sync#2
 *
 * Sealed class
 * Visibility of internal class
 */

val some: SomeClass = SomeClass()
//    val some: SomeClassInternal = SomeClassInternal() // internal in library module - do not compile

sealed class SealedClassExample {

    //nested class
    class FirstSealedClassExample : SealedClassExample()

    //nested data class
    data class SecondSealedClassExample(val n: Int = 1) : SealedClassExample()
}

// same- file classes
class SecondSealedClassExample : SealedClassExample()
class ThrirdSealedClassExample : SealedClassExample()

object objectSealedClass : SealedClassExample()

fun main() {
    val sealed: SealedClassExample = SealedClassExample.FirstSealedClassExample()
    val foo = when (sealed) {
        is SealedClassExample.FirstSealedClassExample -> TODO()
        is SealedClassExample.SecondSealedClassExample -> TODO()
        is SecondSealedClassExample -> TODO()
        is ThrirdSealedClassExample -> TODO()
        objectSealedClass -> TODO()
    }

}