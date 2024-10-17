# Usar una imagen de Java JDK como base
FROM openjdk:17-jdk-slim

# Configurar el directorio de trabajo
WORKDIR /app

# Copiar el archivo de configuración de Firebase en el contenedor
COPY src/main/resources/concurrente-umbrella-firebase-adminsdk-wub2g-ffa07f0960.json /app/firebase-key.json

# Copiar el archivo JAR generado en el contenedor
COPY target/PracticaConcurrenteUmbrella-0.0.1-SNAPSHOT.jar app.jar

# Definir la variable de entorno para la ruta del archivo de clave de Firebase
ENV GOOGLE_APPLICATION_CREDENTIALS="/app/firebase-key.json"

# Exponer el puerto en el que corre la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
