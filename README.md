
# User Management Service

Este microservicio forma parte de la arquitectura de la plataforma de comercio electrónico. Su objetivo principal es gestionar los usuarios, incluyendo la creación, autenticación, y control de acceso.

## 📦 Tecnologías

- Java 17
- Spring Boot 3
- Maven
- PostgreSQL
- Docker
- SonarQube
- GitHub Actions
- DDD, BDD, TDD

## 📁 Estructura del proyecto

```
user-management-service/
├── src/
│   ├── main/
│   │   ├── java/com/eci/...
│   │   └── resources/
│   └── test/
├── Dockerfile
├── sonar-project.properties
├── pom.xml
└── README.md
```

## 🚀 Cómo ejecutar

### Requisitos previos

- Docker y Docker Compose
- JDK 17
- Maven 3.8+

### Ejecutar localmente

1. Clonar el repositorio:

   ```bash
   git clone https://github.com/usuario/user-management-service.git
   cd user-management-service
   ```

2. Construir el proyecto:

   ```bash
   mvn clean install
   ```

3. Ejecutar con Docker:

   ```bash
   docker-compose up --build
   ```

4. Acceder a la aplicación:

   ```
   http://localhost:8080/api/users
   ```

## ✅ Pruebas

```bash
mvn test
```

