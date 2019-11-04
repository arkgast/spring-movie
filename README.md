# Movie Project

Microservices with springboot framework

## Start

### Commands to create the services

    $ spring init -d=web,devtools --build=gradle -a=catalog-service -g=org.veloud catalog-service

    $ spring init -d=web,devtools --build=gradle -a=info-service -g=org.veloud info-service

    $ spring init -d=web,devtools --build=gradle -a=rating-service -g=org.veloud rating-service

### Run

Each microservice runs in a different port:

*catalog service* -> 8081
*info service*    -> 8082
*rating service* -> 8083

    $ ./gradlew bootRUn

> run the command above inside each microservice folder
