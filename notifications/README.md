## XPeppers Microservices Workshop
### The notifications application

#### How to build the application
Maven is needed.
From the project root folder:

`
mvn package
`

#### How to run the application

`
java -jar target/notifications-1.0-SNAPSHOT-jar-with-dependencies.jar
`

#### Docker

**Build the image**

```
docker build -t commerce.notifications .
```

**Run the container**

```
docker run -d --name notifications commerce.notifications:latest
```