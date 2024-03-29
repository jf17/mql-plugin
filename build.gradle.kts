plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.16.0"

    // https://plugins.jetbrains.com/docs/intellij/tools-gradle-grammar-kit-plugin.html
    id("org.jetbrains.grammarkit") version "2021.2.2"
}

group = "ru.jf17"
version = "0.4.5"

repositories {
    mavenCentral()
}

// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    version.set("2023.2.4")
    type.set("IC") // Target IDE Platform

    plugins.set(listOf(/* Plugin Dependencies */))
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }

    generateLexer{
        source.set("src/main/java/ru/jf17/mql/lexer/MQLLexer.flex")
        targetDir.set("src/main/java/ru/jf17/mql/lexer/")
        targetClass.set("MQLLexer")
        purgeOldFiles.set(true)
    }

    patchPluginXml {
        sinceBuild.set("213")
        untilBuild.set("232.*")
    }


    publishPlugin {
        token.set(System.getenv("ORG_GRADLE_PROJECT_intellijPublishToken"))
    }
}

grammarKit {
    jflexRelease.set("1.7.0-1")
    grammarKitRelease.set("2021.1.2")
    intellijRelease.set("203.7717.81")
}
