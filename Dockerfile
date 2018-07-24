FROM maven:3-jdk-8-alpine as builder

COPY src /src
COPY pom.xml /

RUN mvn clean package && mkdir /app && cp -R ./target /app

FROM java:8-jre

COPY --from=builder /app/target/app.jar /app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]