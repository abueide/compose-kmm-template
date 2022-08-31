pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "mnp"
include(":androidApp")
include(":iosCompose")
include(":sharedCompose")
include(":shared")
