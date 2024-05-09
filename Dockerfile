FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
RUN mkdir /app
COPY build/libs/top-trumps-api-0.0.1-SNAPSHOT.jar /app/app.jar
WORKDIR /app
ENTRYPOINT ["java","-jar","app.jar"]