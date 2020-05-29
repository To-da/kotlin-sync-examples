package com.gdata.kotlinsync.restapi

import com.gdata.kotlinsync.restapi.service.FooService
import mu.KotlinLogging

/**
 * Kotlin sync#1
 *
 * Constants
 * Logger
 * Package structure
 */

private val logger = KotlinLogging.logger {}

fun main() {
    FooService().function()
    val const1 = DoSomeWorkService.PUBLIC_CONST
    val const2 = DoSomeWorkService.Foos.PUBLIC_CONST
    val const3 = DoSomeWorkService.Constants.PUBLIC_CONST_2
    logger.info { "Hello Visa" }
    DoSomeWorkService.Constants.doLog()

    //extension
}

fun notExplicitFun() = "hey"

fun explicitFun(): String = "hou"