pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "chiachat"
include(":androidApp")
include(":iosCompose")
include(":sharedCompose")
include(":shared")
