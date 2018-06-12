## XPeppers Microservices Workshop
### The payments application

#### How to build the application
Maven is needed.
From the project root folder:

`
mvn package
`

#### How to run the application

`
java -jar target/payments-1.0-SNAPSHOT-jar-with-dependencies.jar
`

After the application is started, it will be available at the address:

`
http://localhost:8282
`

#### Usage examples
**Make a new payment**

`
curl -X POST -d "order_id=42265410-6d7c-11e8-adc0-fa7ae01bbebc" http://localhost:8282/payments
`

**Get all the payments**

`
curl localhost:8282/payments

#### Docker

**Build the image**

```
docker build -t commerce.payments .
```

**Run the container**

```
docker run -d --name payments -p 8282:8282 commerce.payments:latest
```
`