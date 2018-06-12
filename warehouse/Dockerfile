FROM openjdk:8-jre-alpine

COPY target/warehouse-1.0-SNAPSHOT-jar-with-dependencies.jar /usr/bin/app.jar

WORKDIR /usr/bin

EXPOSE 8181

CMD ["java", "-jar", "app.jar"]