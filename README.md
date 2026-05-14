# EBAC REST Client — Cliente REST con Spring Boot

Cliente REST desarrollado en Java utilizando Spring Boot y RestTemplate para consumir servicios web RESTful.

---

# Tabla de contenidos

- Arquitectura del proyecto
- Tecnologías utilizadas
- Características
- Estructura del proyecto
- Configuración
- Ejecución
- Consumo de APIs REST
- Flujo de comunicación
- Pruebas

---

# Arquitectura del proyecto

La aplicación sigue una arquitectura cliente-servidor para consumo de APIs REST.

```text
┌──────────────────────────────┐
│         Cliente REST         │ ← Solicitudes HTTP
├──────────────────────────────┤
│        Service Layer         │ ← Lógica de consumo
├──────────────────────────────┤
│       RestTemplate           │ ← Cliente HTTP Spring
├──────────────────────────────┤
│         API REST             │ ← Servicio externo
├──────────────────────────────┤
│      Respuesta JSON          │ ← Datos serializados
└──────────────────────────────┘
```

---

# Tecnologías utilizadas

| Tecnología | Uso |
|------------|-----|
| Java 17 | Lenguaje principal |
| Spring Boot | Framework backend |
| RestTemplate | Cliente HTTP |
| Maven | Gestión de dependencias |
| Jackson | Serialización JSON |
| JUnit 5 | Pruebas unitarias |

---

# Características

- Consumo de APIs REST
- Solicitudes HTTP GET/POST
- Manejo de respuestas JSON
- Arquitectura en capas
- Serialización y deserialización
- Integración con servicios externos

---

# Estructura del proyecto

```text
ebac-rest-client/
├── pom.xml
├── README.md
├── src/
│   ├── main/
│   │   ├── java/com/ebac/
│   │   │   ├── client/           ← Cliente REST
│   │   │   ├── service/          ← Lógica de negocio
│   │   │   ├── model/            ← POJOs y DTOs
│   │   │   ├── config/           ← Configuración
│   │   │   └── Application.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
└── target/
```

---

# Configuración

Editar:

```text
src/main/resources/application.properties
```

Ejemplo:

```properties
server.port=8080
api.url=https://api.example.com
```

---

# Ejecución

## Compilar proyecto

```bash
mvn clean install
```

## Ejecutar aplicación

```bash
mvn spring-boot:run
```

---

# Consumo de APIs REST

La aplicación puede consumir:

- Endpoints GET
- Endpoints POST
- APIs JSON
- Servicios externos
- Recursos RESTful

---

# Flujo de comunicación

```text
Cliente → RestTemplate → API REST → JSON → Aplicación
```

---

# Ejemplo de respuesta JSON

```json
{
  "id": 1,
  "name": "Usuario",
  "email": "usuario@email.com"
}
```

---

# Pruebas

## Ejecutar pruebas

```bash
mvn test
```

---

# Mejoras futuras

- Integración con Feign Client
- Manejo avanzado de errores
- Seguridad JWT
- Retry automático
- Logs centralizados

---

# Autor

Xavier Santamaria
