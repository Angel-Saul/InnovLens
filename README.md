# InnovLens



# Introducción

Esta aplicación de escritorio está enfocada para el uso en una óptica local en Xicotepec, gracias a esta aplicación se podrá resolver el problema principal del negocio que es el registro de expedientes de clientes, ya que estos se realizan a mano lo cual es un proceso tardado, que ocasiona una pérdida de tiempo considerable en los clientes, dado a que el proceso se realiza a mano otro problema identificado es la pérdida de información ya que todos los registros están hechos en papel.

Esta aplicación resuelve esos problemas, gracias a que cuenta con las funciones básicas de un punto de venta donde se pueden realizar ventas y actualización de inventario, pero dando un plus a comparación de un punto de venta común ya que esta aplicación incorpora una función para la gestión de expedientes en el cual se podrá llevar a cabo el registro de clientes de una manera más rápida y eficiente, también se podrán actualizar datos de los clientes y asimismo la eliminación de expedientes de clientes que no son regulares.

---

# Diagrama de casos de uso

![Diagrama casos de uso](assets/casosdeuso.jpeg)

---

# Diagrama UML

*(Imagen del diagrama UML)*

---

# Requisitos del sistema

- Java JDK 24 (versión estable)
- Compatible con Windows, Linux y macOS
- Entorno de desarrollo: NetBeans, IntelliJ IDEA o IDE similar con soporte para Java
- Motor de base de datos: MySQL

---

# Método de instalación

1. Clona el repositorio del proyecto.
2. Abre el proyecto en tu IDE (IntelliJ, NetBeans, etc.).
3. Configura la conexión a la base de datos (edita el archivo de configuración o código con tus credenciales de MySQL: usuario, contraseña y nombre de la BD).
4. Ejecuta el archivo principal (`Login.java`).
5. Listo: La aplicación mostrará la ventana de inicio de sesión.

---

# Inicio de sesión

1. **Pantalla de inicio:** Al ejecutar la aplicación, se mostrará la interfaz de login.  
2. **Credenciales:**  
   - Ingrese el usuario y contraseña que se proporcionará por defecto.  
   - Datos de prueba: Usuario: `admin` / Contraseña: `1234`.  
3. **Acceso:**  
   - Si los datos son correctos, el sistema redirigirá al menú principal.  
   - Si son incorrectos, se mostrará un mensaje de error, hasta que se ingresen los datos correctos.

---

# Funciones del sistema

## Menú principal

En el menú principal encontraremos un menú lateral para poder navegar a través de las funciones del sistema.

---

## Formulario de Ventas

1. En este formulario será donde se podrán realizar las operaciones de venta de productos o servicios.
2. Se ingresa el id del producto o del servicio.
3. Una vez ingresado se presiona el botón de **Agregar** y se irán acumulando en la tabla.
4. Para eliminar un producto de la tabla se seleccionará y se presiona el botón de eliminar.
5. Para la consulta de algún producto en específico de la lista solo se deberá presionar el botón de búsqueda.

---

## Formulario de Inventario

1. En el formulario de inventario se encuentran 3 acciones: agregar, editar y eliminar.
2. Cuando se presiona **Agregar**, se abrirá otra interfaz donde se podrán introducir los datos necesarios para poder crear un nuevo producto.
3. Cuando se presiona el botón de **Editar**, de igual manera se abrirá una interfaz nueva. Para poder hacerlo se deberá seleccionar un producto de la tabla, una vez hecho se podrá actualizar el producto.
4. Para poder **eliminar** un producto se deberá seleccionar y presionar el botón de eliminar.

---

## Formulario de Usuarios

En este formulario se podrán gestionar los usuarios que pueden hacer uso del programa.

---

## Formulario de gestión de expedientes

1. En este formulario encontraremos una interfaz con una funcionalidad parecida a la de inventario, donde se podrán crear, editar y eliminar expedientes.
2. Una vez presionado el botón de **Nuevo registro**, este nos llevará a una nueva interfaz donde se ingresan los datos correspondientes.
3. Para poder **editar** un registro se debe seleccionar previamente, luego presionar el botón de editar el cual nos llevará a otra interfaz donde se harán las correcciones.
4. Para **eliminar** un registro se debe seleccionar y presionar el botón de eliminar.
5. Para poder **buscar un expediente** y saber sus detalles se debe ingresar en el cuadro de texto que se encuentra debajo del logo (nombre, id o historial del cliente) y presionar el botón de búsqueda.

---

## Salir del programa

1. Esta acción se puede realizar de 2 maneras:
   - Presionando el botón de **Salir** que se encuentra en el menú lateral de cada interfaz de funciones.  
   - Presionando la **X** que se encuentra en la esquina superior derecha.  

---

# Equipo de desarrollo

- Angel Saul Barrios Martínez
- José María Castillo Aparicio
- Jonhy Neri Hernández
- Obed Vargas Luna


