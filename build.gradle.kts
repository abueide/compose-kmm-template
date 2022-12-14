import com.android.build.gradle.internal.tasks.factory.dependsOn

buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
        classpath("com.android.tools.build:gradle:7.2.2")
        classpath(Plugin.kotlin)
        classpath(Plugin.kotlinxSerialization)
        classpath(Plugin.proguard)
        classpath(Plugin.junitAndroid)
        classpath(Plugin.apollo)
        classpath("dev.icerock.moko:resources-generator:0.20.1")
    }
}

plugins {
    id(Plugin.Id.detekt) version Versions.detekt
    id(Plugin.Id.ktlint) version Versions.ktlint
    id(Plugin.Id.kover) version Versions.kover
}

dependencies {
    detektPlugins(Plugin.detektFormatting)
}

allprojects {
    repositories {
        google()
        mavenLocal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

val rootPackage = "com.dialexa.mnp"
val basePackage = listOf("*", "").map { "$rootPackage.it" }
val excludedPackages = listOf(
    "type", "selections", "adapter", "apollo", "test", "android.test", "compose", ""
).map { "$rootPackage.$it.*" } + "*.BuildConfig" + "*.MainActivity" + "*.**Test"

tasks {
    val checkAndDetekt by registering(io.gitlab.arturbosch.detekt.Detekt::class) {
        dependsOn("check")
        description = "Runs detekt static code analysis on all modules"
        buildUponDefaultConfig = true
        allRules = true
        parallel = true
        ignoreFailures = false
        setSource(files(projectDir))
        include("**/*.kt")
        exclude("**/resources/**")
        exclude("**/build/**")
        config.setFrom("$rootDir/config/detekt/detekt.yml")
        baseline.set(file("$rootDir/config/detekt/baseline.xml"))
        reports {
            html.required.set(true)
            xml.required.set(true)
            sarif.required.set(true)
        }
    }
    val detektProjectBaseline by registering(io.gitlab.arturbosch.detekt.DetektCreateBaselineTask::class) {
        description = "Overrides current baseline."
        buildUponDefaultConfig.set(true)
        ignoreFailures.set(true)
        parallel.set(true)
        setSource(files(rootDir))
        config.setFrom(files("$rootDir/config/detekt/detekt.yml"))
        baseline.set(file("$rootDir/config/detekt/baseline.xml"))
        include("**/*.kt")
        exclude("**/resources/**")
        exclude("**/build/**")
    }
    koverMergedHtmlReport {
        isEnabled = true // false to disable report generation
        htmlReportDir.set(layout.buildDirectory.dir("reports/kover/html"))

        includes = basePackage // inclusion rules for classes
        excludes = excludedPackages
    }

    koverMergedXmlReport {
        isEnabled = true // false to disable report generation
        xmlReportFile.set(layout.buildDirectory.file("reports/kover/report.xml"))

        includes = basePackage // inclusion rules for classes
        excludes = excludedPackages
    }
    koverMergedVerify {
        includes = basePackage
        excludes = excludedPackages
        rule {
            name = "Minimal line coverage rate in percent"
            bound {
                minValue = 75
            }
        }
    }
}
