FROM eclipse-temurin:17-jdk-focal

COPY pet-clinic-webapp/target/pet-clinic-webapp-*-SNAPSHOT.jar app.jar

VOLUME /tmp
EXPOSE 8080
RUN bash -c 'touch /app.jar'
CMD ["java", "-jar","app.jar"]