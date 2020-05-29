dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(project(":library"))

    implementation("org.slf4j:slf4j-simple:1.7.30") // use log4j2 on production project
    implementation("io.github.microutils:kotlin-logging:1.7.8")

    testImplementation("org.junit.jupiter:junit-jupiter:5.6.2")
    testImplementation("io.strikt:strikt-core:0.23.7")
}