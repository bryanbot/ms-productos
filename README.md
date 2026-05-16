# Microservicio de Productos (`ms-productos`)

Este microservicio es el componente central para la gestión del catálogo de suministros. Ha sido diseñado bajo una arquitectura de microservicios escalable, permitiendo el control total sobre el inventario, precios y descripciones de los productos.

## 🛠️ Tecnologías y Herramientas
* **Lenguaje:** Java 17
* **Framework:** Spring Boot 3.5.14
* **Base de Datos:** PostgreSQL (Alojado en Neon Cloud)
* **Gestor de Dependencias:** Maven
* **Validación:** Hibernate Validator

## 🏗️ Arquitectura del Proyecto
El proyecto implementa un patrón de diseño por capas para garantizar la separación de responsabilidades:
- **Controller:** Define los endpoints REST y gestiona las peticiones HTTP.
- **Service:** Contiene la lógica de negocio y reglas de validación.
- **Repository:** Capa de persistencia utilizando Spring Data JPA para la comunicación con PostgreSQL.
- **Entity/DTO:** Modelos de datos y objetos de transferencia para asegurar la integridad de la información.
- **Exception:** Capa para el manejo de excepciones.

## 🚦 Endpoints de la API (CRUD Completo)

| Método | Endpoint | Acción | Código HTTP |
| :--- | :--- | :--- | :--- |
| **POST** | `/api/productos` | Registrar un nuevo producto | `201 Created` |
| **GET** | `/api/productos` | Listar todos los productos | `200 OK` |
| **GET** | `/api/productos/{id}` | Obtener detalle de un producto | `200 OK` |
| **PUT** | `/api/productos/{id}` | Actualizar información completa | `200 OK` |
| **DELETE** | `/api/productos/{id}` | Eliminar producto del catálogo | `204 No Content` |

### Ejemplo de Estructura JSON (Body)
Para las operaciones de creación y actualización:
```json
{
  "nombre": "Teclado Mecánico RGB",
  "descripcion": "Switch Blue, Layout Español, Retroiluminado",
  "precio": 120.50,
  "stock": 25
}
```
## Ejecución en Local
Para su ejecución en local, es importante configurar las siguientes variables de ambiente.
* `DB_URL`: URL de base de datos en Neon.
* `DB_USERNAME`: Usuario de base de datos en Neon.
* `DB_PASSWORD`: Contraseña de base de datos en Neon.
* `PORT`: En este caso se esta usando el puerto 8080.
