<h1 align="center"> API para una Tienda </h1>
Esta es una API hecha con la finalidad de facilitar el trabajo de una persona que administra una tienda (bazar), en la cual puede crear, modificar, y obtener datos de sus ventas, clientes y productos. Todo esto con el lenguaje de programacion Java, implementando una API REST usando el FrameWork Spring Boot. Como proveedor de ORM se utilizó JPA + Hibernate. Para realizar las pruebas de la API se utilizó Postman. Y todos los objetos fueron almacenados en una base de datos MySQL con la herramienta de PhpMyAdmin.

## Modelado
A partir de las necesidades basicas de una tienda, las clases que se crearon fueron las siguinetes:
- Producto
- Venta
- Cliente

En donde  una venta tiene una lista de productos, y una venta solo puede tener un cliente.

## :hammer:Funcionalidades del proyecto

- `CRUD completo de productos, cliente y venta`
-  `Obtener productos cuya cantidad sea menor a 5 en stock`
-  `Obtener productos de una Venta determinada`
-  `Obtener el costo total de una venta y las ventas de un determinado día`
-  `Obtener el codigo de venta, el total, la cantidad de productos, el nombre y el apellido del cliente de la venta con el costo mas alto de todas las ventas`

Encuentra aquí el [link de PostMan](https://www.postman.com/jairoixis/workspace/portafolio/collection/36228688-7b7efb74-a7a5-472a-a4dd-ce55a41f853f?action=share&creator=36228688) en donde se enceuntran todos los endpoints para realizar las pruebas de la API.
