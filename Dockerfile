FROM 3.6.3-openjdk-15 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:14
COPY --from=build /usr/src/app/target/employees-backend-0.0.1-SNAPSHOT.jar /usr/app/app-backend.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/app.jar"]