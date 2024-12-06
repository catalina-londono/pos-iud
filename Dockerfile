FROM openjdk:17-jdk-slim

WORKDIR /app

COPY ./target/pos-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8084

CMD ["java","-Dspring.profiles.active=default","-jar", "app.jar"]