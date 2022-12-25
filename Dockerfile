FROM maven:3.6.3-openjdk-17 AS build
COPY src /hotelManagementSystem/src
COPY pom.xml /hotelManagementSystem
RUN mvn -f /hotelManagementSystem/pom.xml clean compile package

FROM openjdk:17
COPY --from=build /hotelManagementSystem/target/hotelManagementSystem-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","hotelManagementSystem-0.0.1-SNAPSHOT.jar"]