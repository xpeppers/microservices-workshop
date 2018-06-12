FROM openjdk:8-jre-alpine

COPY target/payments-1.0-SNAPSHOT-jar-with-dependencies.jar /usr/bin/app.jar

WORKDIR /usr/bin

EXPOSE 8282

CMD ["java", "-jar", "app.jar"]