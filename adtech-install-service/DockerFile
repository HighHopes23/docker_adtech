FROM openjdk:8
ADD target/adtech-0.0.1-SNAPSHOT.jar adtech-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://springboot-mongo:27017/springmongo-demo", "-jar", "adtech-0.0.1-SNAPSHOT.jar"]