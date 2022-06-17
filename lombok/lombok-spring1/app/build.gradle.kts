plugins {
    id("org.springframework.boot") version "2.7.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    java
    application
}

repositories {
    mavenCentral()
}

var lombokVersion = "1.18.24"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
	compileOnly("org.projectlombok:lombok:${lombokVersion}")
    annotationProcessor("org.projectlombok:lombok:${lombokVersion}")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}


application {
    // Define the main class for the application.
    mainClass.set("com.stulsoft.pspring.lombok.App")
}
