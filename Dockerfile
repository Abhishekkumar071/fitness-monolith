#FROM ubuntu:latest
#LABEL authors="abhis"
#
#ENTRYPOINT ["top", "-b"]

FROM eclipse-temurin:25-jre
WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

#docker build -t fitness-monolith .
#docker run -p 8080:8080 fitness-monolith

#docker tag fitness-monolith abhishekbgp/fitness-monolith
# docker push abhishekbgp/fitness-monolith
#docker login


#docker run -p 8080:8080 -e DB_URL=jdbc:mysql://host.docker.internal:3306/fitness_db -e DB_USERNAME=root -e DB_PASSWORD=test123 fitness-monolith