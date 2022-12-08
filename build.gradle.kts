plugins {
    id("java")
    application
}

val mainPackage = "com.mazylol.dexter"

group = mainPackage
version = "0.1"

val jdaVersion = "5.0.0-beta.1"

repositories {
    mavenCentral()
    maven("https://m2.dv8tion.net/releases")
}

dependencies {
    implementation("net.dv8tion:JDA:$jdaVersion") {
        exclude(module = "opus-java")
    }
    implementation("com.github.oscar0812:pokeapi:2.0.0")
    implementation("io.github.cdimascio:dotenv-java:2.3.1")
    implementation("ch.qos.logback:logback-classic:1.4.5")

}

application {
    mainClass.set("$mainPackage.Bot")
}

distributions {
    main {
        contents {
            from(".env")
        }
    }
}