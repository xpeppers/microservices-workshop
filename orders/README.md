## XPeppers Microservices Workshop
### The orders application

#### How to build the application
Maven is needed.
From the project root folder:

`
mvn package
`

#### How to run the application

`
java -jar target/orders-1.0-SNAPSHOT-jar-with-dependencies.jar
`

After the application is started, it will be available at the address:

`
http://localhost:4567
`

#### Usage examples
**Make a new order**

`
curl -X POST -d "product_code=111&product_quantity=1" localhost:4567/orders
`

Responses:
`order confirmed` or `product not available`

**Get all the orders**

`
curl localhost:4567/orders
`

Response:
```json
[
    {
        "id": "1c35b140-58f7-4cd9-8e4e-6e94d304e428",
        "productCode": "111",
        "productQuantity": 1
    }
]
```