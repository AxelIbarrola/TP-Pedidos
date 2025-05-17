package com.techlab.service;
import com.techlab.excepciones.PedidoInvalidoException;
import com.techlab.pedidos.LineaPedido;
import com.techlab.productos.Producto;
import com.techlab.pedidos.Pedido;


import java.util.ArrayList;

public class PedidoService{
    private final ArrayList<Pedido> pedidos = new ArrayList<>();

    public void agregarPedido(Pedido pedido){
        if (pedido == null) {
            throw new PedidoInvalidoException("El pedido no puede ser null.");
        } else {
            this.pedidos.add(pedido);
        }
    }

    public void mostrarPedidos(){
        System.out.println("Lista de pedidos realizados: ");

        for (Pedido pedido : pedidos){
            System.out.println("Id: " + pedido.getId());
            System.out.println("Productos asociados:");

            for (LineaPedido lineaPedido : pedido.getLineaPedido()){
                Producto producto = lineaPedido.getProducto();
                System.out.println(producto + "| Cantidad: " + lineaPedido.getCantidad());
            }

            System.out.println("Precio total: " + pedido.calcularTotal());

        }
    }
}