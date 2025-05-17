# 🛒 Sistema de Gestión de Productos y Pedidos

Este proyecto es una aplicación de consola desarrollada en Java que permite gestionar productos y realizar pedidos. Está diseñado siguiendo principios de programación orientada a objetos y buenas prácticas como el uso de excepciones personalizadas, separación de responsabilidades y validaciones robustas.
Es un proyecto con fines educativos para el programa de TalentoTech, es mi primer contacto con Java.
---

## 📋 Funcionalidades

### Gestión de Productos
- Agregar productos con nombre, precio y stock.
- Listar todos los productos.
- Buscar productos por nombre o por ID.
- Eliminar productos por ID.
- Validación de datos de entrada y manejo de excepciones.

### Gestión de Pedidos
- Crear pedidos seleccionando productos disponibles.
- Validar cantidad solicitada contra el stock.
- Calcular total del pedido.
- Listar todos los pedidos realizados.
- Descontar automáticamente el stock del producto al generar un pedido.

---

## 🧩 Estructura del Proyecto

- `com.techlab.productos` → Clases relacionadas a productos (`Producto`, validaciones).
- `com.techlab.pedidos` → Clases de pedidos (`Pedido`, `LineaPedido`).
- `com.techlab.service` → Servicios (`ProductoService`, `PedidoService`).
- `com.techlab.excepciones` → Excepciones personalizadas para validación.
- `com.techlab.vista` → Interfaz de consola con menú interactivo (`Main`).

---

## ✅ Tecnologías Utilizadas

- Java 17
- IntelliJ IDEA
- Git & GitHub

---

## 🚀 Cómo ejecutar

1. Cloná el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/tu-repo.git
   cd tu-repo
