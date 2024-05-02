FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
RUN mkdir /app
COPY app.jar /app/app.jar
WORKDIR /app
ENTRYPOINT ["java","-jar","app.jar"]