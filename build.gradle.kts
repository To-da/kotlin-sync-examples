plugins {
//    kotlin("jvm") version "1.3.72" apply false
    kotlin("jvm") version "1.4-M2" apply false //download kotlin EAP plugin for IDEA support
}

allprojects {
    group = "com.gdata"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenLocal()
        mavenCentral()
        jcenter()
        maven ("https://dl.bintray.com/kotlin/kotlin-eap")
        maven ("https://kotlin.bintray.com/kotlinx")
    }
}

subprojects {
    apply(plugin = "kotlin")

    configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    tasks.withType<Test> {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            /**
             * -Xjsr305=strict : to have null-safety taken in account in Kotlin types inferred from libraries APIs
             * -Xopt-in=kotlin.RequiresOptIn : experimental features enabled by default
             */
            freeCompilerArgs = listOf("-Xjsr305=strict","-Xopt-in=kotlin.RequiresOptIn")
            jvmTarget = JavaVersion.VERSION_11.majorVersion
        }
    }
}