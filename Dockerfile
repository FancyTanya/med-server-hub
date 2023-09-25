FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /build
COPY src ./src
COPY pom.xml ./
RUN mvn clean package -DskipTests

FROM openjdk:17
WORKDIR /app
COPY --from=build /build/target/medserverhub*jar medserverhub.jar
EXPOSE 8080
CMD ["java", "-jar", "medserverhub.jar"]
