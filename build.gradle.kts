// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Config.Plugins.androidApplication) version Versions.androidApplication apply false
    id(Config.Plugins.androidLibrary) version Versions.androidLibrary apply false
    id(Config.Plugins.kotlinAndroid) version Versions.kotlinAndroid apply false
    id(Config.Plugins.kapt) version Versions.kapt apply false
    id(Config.Plugins.hilt) version Versions.hilt apply false
    id(Config.Plugins.apollo) version Versions.apollo apply false
    id(Config.Plugins.ktlint) version Versions.ktlint apply false
}

allprojects {
    apply {
        plugin(Config.Plugins.ktlint)
    }
    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        debug.set(false)
        verbose.set(true)
        android.set(false)
        outputToConsole.set(true)
        outputColorName.set("RED")
        ignoreFailures.set(false)
        filter {
            exclude("/com/zeus/apollo/**")
            include("**/kotlin/**")
        }
    }
}

tasks.register("setGitHooks") {
    copy {
        from("pre-commit")
        into(".git/hooks")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
