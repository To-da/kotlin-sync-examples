package com.gdata.kotlinsync.restapi

import mu.KLoggable

/**
 * Kotlin sync#1
 *
 * Constants
 */

private const val PRIVATE_CONST = 1 // for constants used by more top-level declarations

class DomainException: RuntimeException()

class DoSomeWorkService {

    /**
     * companion object name can be omitted
     */
    companion object Foos {
        private const val PRIVATE_COMP_CONST = PRIVATE_CONST // for private constants
        const val PUBLIC_CONST = PRIVATE_CONST // for public constants
    }

    object Constants : Log, KLoggable {
        const val PUBLIC_CONST_2 = PRIVATE_CONST

        override val logger = logger()


        override fun doLog() {
            logger.info { "log from object" }
        }
    }

    interface Log {
        fun doLog()
    }
}

