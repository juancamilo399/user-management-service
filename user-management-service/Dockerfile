# Imagen base con JDK 17
FROM openjdk:17-jdk-slim

# Nombre del archivo JAR generado por Maven
ARG JAR_FILE=target/user-management-service-1.0-SNAPSHOT.jar

# Carpeta de trabajo dentro del contenedor
WORKDIR /app

# Copiar el JAR desde el host al contenedor
COPY ${JAR_FILE} app.jar

# Puerto expuesto (Spring Boot usa 8080 por defecto)
EXPOSE 8080

# Comando de arranque
ENTRYPOINT ["java", "-jar", "app.jar"]
