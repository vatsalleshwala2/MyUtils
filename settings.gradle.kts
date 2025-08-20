pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
//        jcenter()
        maven { url = uri("https://jcenter.bintray.com") }
    }
}
dependencyResolutionManagement {
//    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
//        jcenter()
    }
}

rootProject.name = "My Utils"
include(":app")
include(":myUtils")
