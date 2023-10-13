# [Product-Reserver](https://github.com/Marc0Franc0/Product-Reserver#product-reserver)

Proyecto que consiste en implementar un sistema de microservicios para gestionar reservas de productos. Cada microservicio se encarga de una función específica y se comunica con otros, simplificando el proceso de reserva de productos.

## Tecnologías
- Spring Boot 3.1.4
- Java 21
- Spring Cloud
- Maven
- MySQL
- MongoDB

## Componentes del proyecto
### Api Gateway
  API Gateway sirve como punto de entrada único para todas las solicitudes de los del stock, los productos y reservas a los microservicios apropiados.

### Config Server
Config Server centraliza la gestión de la configuración para todos los microservicios, simplificando el mantenimiento de las aplicaciones y la coherencia en todos los entornos.

### Discovery Service
Discovery Service proporciona registro y descubrimiento de servicios, lo que permite una comunicación fluida entre servicios dentro del ecosistema de microservicios.

### Product Microservice
El microservicio para productos es responsable de administrar datos y operaciones relacionados con los productos.

### Stock Microservice
El microservicio Stock gestiona datos y operaciones relacionados con el stock de productos.

### Booking Microservice
El microservicio Booking proporciona endpoints al igual que los demas pero este se encarga de las reservas de productos.

## Comunicación entre servicios
### Se utiliza OpenFeign
Este proyecto demuestra la comunicación entre servicios utilizando OpenFeign, un cliente REST declarativo que simplifica la comunicación entre servicios dentro del ecosistema de microservicios.

## Ejecución
1. Clonar repositorio: git clone https://github.com/Marc0Franc0/Product-Reserver
2. Ir al directorio del proyecto: Product-Reserver
3. Seguir pasos para ejecución con Docker

## Requerimientos para ejecutar con Docker

Para construir y ejecutar la aplicación necesita:
- [Docker](https://www.docker.com/products/docker-desktop/)

Ejecutar localmente

```shell
docker compose up --build
```

Dirigirse a: 
- [http://localhost:8080/](http://localhost:9090/)
- [http://localhost:8080/webjars/swagger-ui/index.html](http://localhost:8080/webjars/swagger-ui/index.html)