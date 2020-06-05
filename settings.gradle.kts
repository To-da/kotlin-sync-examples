rootProject.name = "kotlin-sync-examples"

include("rest-api")
include("library")
include("sam-functions")

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven ("https://dl.bintray.com/kotlin/kotlin-eap")
    }
}
