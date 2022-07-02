plugins {
    id("org.springframework.boot") version "2.7.1"
    id("io.spring.dependency-management") version "1.0.12.RELEASE"
    java
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}


application {
    // Define the main class for the application.
    mainClass.set("com.stulsoft.pspring.App")
}
