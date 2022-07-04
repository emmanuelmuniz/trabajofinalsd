FROM openjdk:11
EXPOSE 8081
ADD target/items-service-0.0.1-SNAPSHOT.jar items-service.jar
ENTRYPOINT ["java", "-jar","items-service.jar"]