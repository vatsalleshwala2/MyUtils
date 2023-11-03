import org.gradle.api.publish.maven.internal.publisher.MavenPublisher

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.myutils"
    compileSdk = 34

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
//publishing {
//    publications {
//        create<MavenPublication>("bar") {
//            groupId = "com"
//            artifactId = "myutils"
//            version = "1.0"
//            artifact(file("$buildDir/outputs/aar/myUtils-release.aar"))
//        }
//    }
//
//    repositories {
//        maven {
//            name = "GithubPackages"
//            url = uri("https://maven.pkg.github.com/vatsalleshwala2/MyUtils")
//            credentials {
//                username = System.getenv("GITHUB_USER")
//                password = System.getenv("GITHUB_TOKEN")
//            }
//        }
//    }
//
//}


dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //dialog
//    implementation ("com.github.d-max:spots-dialog:1.1@aar")
    //size
    implementation ("com.intuit.ssp:ssp-android:1.1.0")
    implementation ("com.intuit.sdp:sdp-android:1.1.0")
}



publishing {
    publications {
        register<MavenPublication> ("release") {
            groupId = "com.github.vatsalleshwala2"
            artifactId = "MyUtils"
            version = "1.0"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}