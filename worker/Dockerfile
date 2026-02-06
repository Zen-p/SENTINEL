FROM maven:3.9-eclipse-temurin-25 AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src

# Исправляем опечатку в команде
RUN mvn clean package -DskipTests

FROM eclipse-temurin:25-jre-jammy
WORKDIR /app

# Проверь путь! Если это стандартный проект, то: /app/target/*.jar
COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
