# Hello World API

A simple Spring Boot web application with Swagger (OpenAPI) documentation.

## Run

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

## Endpoints

| URL | Description |
|-----|-------------|
| http://localhost:8080/api/hello | Hello World REST endpoint |
| http://localhost:8080/api/hello?name=Alice | Personalized greeting |
| http://localhost:8080/swagger-ui.html | Swagger UI |
| http://localhost:8080/api-docs | OpenAPI JSON |

## Stack

- Java 21
- Spring Boot 4.1
- springdoc-openapi (Swagger UI)
