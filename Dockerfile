FROM openjdk:18
WORKDIR /app
COPY ./target/ACSUS-1-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java", "-jar", "ACSUS-1-0.0.1-SNAPSHOT.jar"]
 
 