plugins {
    kotlin("jvm") version "1.9.22"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    google {
        content {
            includeGroupByRegex("com\\.android.*")
            includeGroupByRegex("com\\.google.*")
            includeGroupByRegex("androidx.*")
        }
    }
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")
    implementation("com.google.code.gson:gson:2.11.0")

//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.2")
//    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.2")
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")


}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}