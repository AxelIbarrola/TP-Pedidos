package com.techlab.vista;
import com.techlab.excepciones.*;
import com.techlab.pedidos.LineaPedido;
import com.techlab.pedidos.Pedido;
import com.techlab.productos.Producto;
import com.techlab.service.PedidoService;
import com.techlab.service.ProductoService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ProductoService productoService = new ProductoService();
        PedidoService pedidoService = new PedidoService();

        int opcion = 0;

        do {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Buscar producto por nombre");
            System.out.println("4. Buscar producto por ID");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Crear pedido");
            System.out.println("7. Listar pedidos");
            System.out.println("8. Salir");
            System.out.print("Ingrese una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                if (opcion < 1 || opcion > 8) {
                    System.out.println("Opción inválida, debe ingresar un número entre 1 y 8.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida. Ingrese un número.");
                continue;
            }

            switch (opcion) {
                case 1:
                    try {
                        System.out.println("\nIngrese los datos del producto.");

                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Precio: ");
                        double precio = Double.parseDouble(scanner.nextLine());

                        System.out.print("Stock: ");
                        int stock = Integer.parseInt(scanner.nextLine());

                        Producto producto = new Producto(nombre, precio, stock);
                        productoService.agregarProducto(producto);
                        System.out.println("Producto agregado con éxito.");

                    } catch (NumberFormatException e) {
                        System.out.println("Error: Ingrese números válidos para precio y stock.");
                    } catch (NombreInvalidoException | PrecioInvalidoException | StockInvalidoException e) {
                        System.out.println("Error de validación: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Error inesperado: " + e.getMessage());
                    }

                    break;

                case 2:
                    productoService.mostrarProductos();
                    break;

                case 3:
                    System.out.print("\nIngrese el nombre del producto: ");
                    String nombre = scanner.nextLine();

                    if (nombre == null || nombre.isBlank()) {
                        System.out.println("El nombre no puede estar vacío.");
                        break;
                    }

                    Producto productoBuscarPorNombre = productoService.buscarProductoPorNombre(nombre.trim());

                    if (productoBuscarPorNombre != null) {
                        System.out.println("\nProducto encontrado con éxito: ");
                        System.out.println(productoBuscarPorNombre);
                    } else {
                        System.out.println("No se encontró ningún producto con ese nombre.");
                    }

                    break;

                case 4:

                    int idProductoBuscar;

                    try {
                        System.out.print("\nIngrese el id del producto que desea buscar: ");
                        idProductoBuscar = Integer.parseInt(scanner.nextLine());

                        if (idProductoBuscar < 1) {
                            System.out.println("Error: el id debe ser mayor que 0.");

                        } else {

                            Producto productoPorId = productoService.buscarProductoPorId(idProductoBuscar);

                            if (productoPorId != null) {
                                System.out.println("Producto encontrado éxitosamente: ");
                                System.out.println(productoPorId);

                            } else {
                                System.out.println("No se encontró ningún producto con ese id.");
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: el id debe ser un número entero.");
                    }

                    break;

                case 5:

                    int idProductoEliminar;

                    try {
                        System.out.print("\nIngrese el id del producto que desea eliminar: ");
                        idProductoEliminar = Integer.parseInt(scanner.nextLine());

                        if (idProductoEliminar < 1) {
                            System.out.println("Error: el id debe ser mayor que 0.");

                        } else {
                            productoService.eliminarProducto(idProductoEliminar);
                            System.out.println("Producto eliminado con éxito.");
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Error: el id debe ser un número entero.");
                    } catch (ProductoNoEncontradoException e) {
                        System.out.println("Error en la búsqueda de producto: " + e.getMessage());

                    } catch (Exception e) {
                        System.out.println("Error inesperado: " + e.getMessage());
                    }

                    break;

                case 6:
                    try {
                        Pedido pedido = new Pedido();

                        while (true) {
                            productoService.mostrarProductos();
                            System.out.print("\nIngrese el id del producto que desea ingresar al pedido: ");
                            int idProductoParaPedido = Integer.parseInt(scanner.nextLine());
                            Producto productoParaPedido = productoService.buscarProductoPorId(idProductoParaPedido);
                            if (productoParaPedido == null) {
                                System.out.println("No se encontró ningún producto con ese id. Intente nuevamente.");
                                continue;
                            }

                            System.out.print("Ingrese la cantidad que desea del producto seleccionado: ");
                            int cantidad = Integer.parseInt(scanner.nextLine());

                            if (cantidad > productoParaPedido.getStock()) {
                                System.out.println("Error: Stock insuficiente para ese producto.");
                                continue;
                            }

                            LineaPedido lineaPedido = new LineaPedido(productoParaPedido, cantidad);
                            pedido.agregarLineaPedido(lineaPedido);

                            System.out.print("¿Desea agregar otro producto?(S/N): ");
                            String opcionSalida = scanner.nextLine();

                            if (opcionSalida.equalsIgnoreCase("n")) break;
                        }

                        if (!pedido.getLineaPedido().isEmpty()) {
                                pedido.confirmarPedido();
                                pedidoService.agregarPedido(pedido);
                                System.out.println("Pedido creado con éxito. Total: $" + pedido.calcularTotal());

                        } else {
                            System.out.println("No se agregó ningún producto al pedido.");
                        }


                    } catch (NumberFormatException e) {
                        System.out.println("Error: debe ingresar un número válido.");
                    } catch (PedidoInvalidoException | StockInsuficienteException | IllegalArgumentException |
                             CantidadInvalidaException | ProductoInvalidoException e) {
                        System.out.println("Error: " + e.getMessage());

                    }

                    break;

                case 7:
                    pedidoService.mostrarPedidos();
                    break;

                case 8:
                    System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                    break;


            }
        } while (opcion != 8);

        scanner.close();

    }
}