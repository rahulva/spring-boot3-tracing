FROM adoptopenjdk/openjdk11:alpine

COPY target/tire1-1.0-SNAPSHOT.jar tire1.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/tire1.jar"]