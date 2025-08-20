import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.myutils"
    compileSdk = 36

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
//    kotlinOptions {
//        jvmTarget = "11"
//    }
    kotlin {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.17.0")
    implementation("androidx.appcompat:appcompat:1.7.1")
    implementation("com.google.android.material:material:1.12.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.3.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.7.0")

    //dialog
//    implementation ("com.github.d-max:spots-dialog:1.1@aar")
    //size
    implementation ("com.intuit.ssp:ssp-android:1.1.1")
    implementation ("com.intuit.sdp:sdp-android:1.1.1")
    //Gson
    implementation ("com.google.code.gson:gson:2.13.1")
    //retrofit
    implementation("com.squareup.retrofit2:converter-gson:3.0.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.1.0")

}



publishing {
    publications {
        register<MavenPublication> ("release") {
            groupId = "com.github.vatsalleshwala2"
            artifactId = "MyUtils"
            version = "1.4.8"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}