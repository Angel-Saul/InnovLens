# InnovLens

**InnovaLens** es una aplicación de escritorio desarrollada en Java con arquitectura por capas, diseñada para gestionar eficientemente una óptica. El sistema permite el manejo completo de **expedientes de pacientes** y **inventario de productos**, utilizando operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en ambas funcionalidades.

Este proyecto fue desarrollado con enfoque en modularidad, mantenibilidad y escalabilidad, siguiendo buenas prácticas de programación orientada a objetos y diseño por capas.

---

## 📌 Funcionalidades Principales

- ✅ **Gestión de Expedientes Médicos**
  - Registro completo del paciente (datos personales, historial visual, recetas, etc.)
  - Búsqueda y edición de expedientes
  - CRUD completo mediante interfaz gráfica

- ✅ **Gestión de Inventario**
  - Control de productos (lentes, monturas, accesorios)
  - Registro de stock, precios y proveedores
  - Actualización y eliminación segura de productos

- ✅ **Interfaz Gráfica Amigable (Swing)**
  - Menú principal intuitivo
  - Formularios para creación y edición
  - Navegación entre módulos

- ✅ **Autenticación de Usuarios**
  - Inicio de sesión seguro
  - Gestión de usuarios y roles

- ✅ **Base de Datos Relacional (MySQL)**
  - Persistencia de datos mediante JDBC
  - Conexión estable y configurada

---

## 🏗️ Arquitectura por Capas

El sistema sigue una arquitectura de **4 capas bien definidas**, separando responsabilidades para facilitar el mantenimiento y escalabilidad:

### 🔹 Capa 1: **Vista (View)**  
> Responsable de la interfaz gráfica del usuario.

- Ubicación: `com.mycompany.innovalens.view`
- Contiene todos los formularios (`frmLogin`, `frmExpedientes`, `frmInventario`, etc.)
- Se encarga únicamente de mostrar información y capturar entradas del usuario.
- No contiene lógica de negocio ni acceso directo a base de datos.

### 🔹 Capa 2: **Conexión (Connection Layer)**  
> Gestiona la comunicación con la base de datos.

- Ubicación: `conexion`
- Clase principal: `conexionDB.java`
- Establece la conexión JDBC con MySQL.
- Proporciona métodos para abrir/cerrar conexiones y manejar excepciones.

### 🔹 Capa 3: **Acceso a Datos (DAO - Data Access Objects)**  
> Maneja todas las operaciones CRUD con la base de datos.

- Ubicación: `dao`
- Clases: `expedienteDAO.java`, `productoDAO.java`, `usuariosDAO.java`, etc.
- Cada DAO se encarga de una entidad específica.
- Usa sentencias SQL y métodos para insertar, leer, actualizar y eliminar registros.
- Actúa como puente entre la vista y la base de datos.

### 🔹 Capa 4: **Transferencia de Datos (DTO - Data Transfer Objects)**  
> Representa los objetos de datos que se intercambian entre capas.

- Ubicación: `dto`
- Clases: `UserDto.java`, `dtoExpediente.java`, `dtoProducto.java`, etc.
- Son clases simples que contienen atributos y métodos getters/setters.
- Permiten pasar datos de forma segura entre capas sin exponer la estructura interna.

---

## 🛠️ Tecnologías Utilizadas

| Tecnología     | Descripción |
|---------------|------------|
| **Java SE 8+** | Lenguaje principal de desarrollo |
| **Swing**      | Interfaz gráfica de usuario |
| **MySQL**      | Base de datos relacional |
| **JDBC**       | Conexión entre Java y MySQL |
| **NetBeans / Eclipse** | IDE utilizado para desarrollo |
| **MVC (estilo)** | Patrón de diseño aplicado mediante capas |
