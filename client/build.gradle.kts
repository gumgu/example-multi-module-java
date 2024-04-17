dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.json:json:20210307")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

}

