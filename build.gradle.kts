plugins {
    kotlin("jvm") version "1.3.72" apply false
}

allprojects {
    group = "com.gdata"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenLocal()
        mavenCentral()
        jcenter()
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