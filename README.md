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

## ⚙️ Variables de Enorno Necesarias
Para que el microservicio pueda conectarse a la base de datos relacional en la nube, se deben configurar las siguientes variables en el entorno de ejecución (ya sea en las variables del sistema en local o en el panel de Render):

| Variable | Descripción | Ejemplo de Valor |
| :--- | :--- | :--- |
| `SPRING_DATASOURCE_URL` | URL de conexión JDBC a PostgreSQL en Neon | `jdbc:postgresql://ep-cool-darkness-a5.us-east-2.aws.neon.tech/neondb` |
| `SPRING_DATASOURCE_USERNAME` | Usuario de la base de datos | `neondb_owner` |
| `SPRING_DATASOURCE_PASSWORD` | Contraseña asignada en Neon DB | `AbC123XyZ789` |

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
## 💻 Instrucciones para Ejecutar en Local
1. Clonar el repositorio:
```bash
git clone https://github.com/bryanbot/ms-productos.git
cd ms-productos
```
2. Configurar las Variables de Entorno:
Asegúrese de exportar las variables mencionadas en la sección anterior o configurarlas en las propiedades de ejecución de su IDE (Eclipse / Intellij IDEA).
* `DB_URL`: URL de base de datos en Neon.
* `DB_USERNAME`: Usuario de base de datos en Neon.
* `DB_PASSWORD`: Contraseña de base de datos en Neon.
* `PORT`: En este caso se esta usando el puerto `8080`.
3. Compilar y construir el archivo ejecutable (.jar)
```bash
mvn clean install
```
4. Levantar el servicio
```bash
mvn spring-boot:run
```
