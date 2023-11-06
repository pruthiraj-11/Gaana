pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://www.jitpack.io")}
    }
}

rootProject.name = "Gaana"
include(":app")
include(":lib:extensions")
include(":lib:icons_pack")
include(":lib:mediaplayer")
include(":lib:utils")
