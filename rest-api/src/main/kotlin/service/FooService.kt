package com.gdata.kotlinsync.restapi.service

import mu.KLogging
import mu.KotlinLogging

class FooService {

    private val logger2 = KotlinLogging.logger {}

    companion object: Foo, KLogging() {
        val foo = 1
    }

    fun function() {
        logger2.info { "foo 2" }
        logger.info { " foo" }
    }

    interface Foo

}