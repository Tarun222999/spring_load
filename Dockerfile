FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/demo-0.0.1-SNAPSHOT.jar load-generator.jar
ENTRYPOINT ["java","-jar","/load-generator.jar"]