package com.gdata.kotlinsync.restapi.sync2

import kotlin.reflect.KClass

/**
 * Kotlin sync#2
 *
 * multicatch examples
 */

fun main() {
    val unitAction = { println("do some work") }
    val stringAction = { "do some work".also(::println) }

    var value: String = ""
    var unit: Unit

    unit = catchBlock(unitAction)
    value = catchBlock(stringAction)

    unit = runCatching(unitAction)
    value = runCatching(stringAction)

    unit = catchFunction(unitAction)
    value = catchFunction(stringAction)
}

fun <R> catchBlock(action: () -> R): R {
    try {
        return action()
    } catch (ex: Exception) {
        when (ex) {
            is IllegalAccessException, is IndexOutOfBoundsException -> {
                // handle IllegalAccessException or IndexOutOfBoundsException
                throw RuntimeException("handled")
            }
            else -> throw ex
        }
    }
}

/**
 * [kotlin.runCatching] + [Result]
 */
fun <R> runCatching(action: () -> R): R {
    return kotlin.runCatching(action)
            .onFailure {
                when (it) {
                    is IllegalAccessException, is IndexOutOfBoundsException -> {
                        // handle IllegalAccessException or IndexOutOfBoundsException
                        throw RuntimeException("handled")
                    }
                }
            }
            .getOrThrow()
}


/**
 * Custom
 */
fun <R> catchFunction(action: () -> R) =
        { action() }
                .catch(IllegalAccessException::class, IndexOutOfBoundsException::class) {
                    // handle IllegalAccessException or IndexOutOfBoundsException
                    throw RuntimeException("handled")
                }

fun <R> (() -> R).catch(vararg exceptions: KClass<out Throwable>, catchBlock: (Throwable) -> R) =
        try {
            this()
        } catch (e: Throwable) {
            if (e::class in exceptions) catchBlock(e) else throw e
        }