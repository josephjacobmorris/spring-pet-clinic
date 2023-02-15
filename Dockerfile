FROM eclipse-temurin:17-jdk-focal

COPY pet-clinic-webapp/target/pet-clinic-webapp-*-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar","app.jar"]