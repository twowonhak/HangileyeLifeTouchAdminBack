plugins {
    java
    war
    id("org.springframework.boot") version "2.7.12"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
}

group = "com.hangileye"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.1.3")
    implementation("org.springframework.boot:spring-boot-starter-aop")
//    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.1.3")
    // implementation("org.springframework.boot:spring-boot-starter-security")
    compileOnly("org.projectlombok:lombok")

    runtimeOnly("com.oracle.database.jdbc:ojdbc8")

    annotationProcessor("org.projectlombok:lombok")
    implementation("org.springframework.boot:spring-boot-starter-tomcat")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    compileOnly("org.springframework.boot:spring-boot-devtools")
    implementation("com.oracle.ojdbc:orai18n:19.3.0.0")

    implementation("org.webjars:sockjs-client:1.5.1")
    implementation("org.webjars:stomp-websocket:2.3.4")
    implementation("org.springframework.boot:spring-boot-starter-websocket")

    // log
    implementation("org.bgee.log4jdbc-log4j2:log4jdbc-log4j2-jdbc4.1:1.16") /* Log4JDBC */

    // StringUtils
    implementation("org.apache.commons:commons-lang3:3.12.0")

    // https://mvnrepository.com/artifact/org.json/json
    implementation("org.json:json:20231013")
    // https://mvnrepository.com/artifact/net.minidev/json-smart
    implementation("net.minidev:json-smart:2.4.11")

//    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.google.code.gson:gson:2.8.9")

//    implementation("com.fasterxml.jackson.core', name: 'jackson-databind', version: '2.13.2")
    implementation("net.java.dev.jna:jna:5.12.1")
    implementation("net.java.dev.jna:jna-platform:5.12.1")

    // JWT
    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    implementation("io.jsonwebtoken:jjwt-impl:0.11.5")
    implementation("io.jsonwebtoken:jjwt-jackson:0.11.5")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
