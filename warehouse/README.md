## XPeppers Microservices Workshop
### The warehouse application

#### How to build the application
Maven is needed.
From the project root folder:

`
mvn package
`

#### How to run the application

`
java -jar target/warehouse-1.0-SNAPSHOT-jar-with-dependencies.jar
`

After the application is started, it will be available at the address:

`
http://localhost:8181
`

#### Usage examples
**Reserve products for an Order**

`
curl -X POST -d "product_code=111&product_quantity=1&order_id=3b3a2a7a-6d52-11e8-adc0-fa7ae01bbebc" http://localhost:8181/pickProducts
`

**Get all the reserved products**

`
curl localhost:8181/reservedProducts
`

Response:
```json
[
  {
    "orderId": "3b3a2a7a-6d52-11e8-adc0-fa7ae01bbebc",
    "code": "111",
    "quantity": 1
   }
]
```