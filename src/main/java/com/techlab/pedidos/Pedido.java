package com.techlab.pedidos;
import java.util.ArrayList;

public class Pedido {
    private final int id;
    private static int contadorId = 1;
    private final ArrayList<LineaPedido> lineaPedido = new ArrayList<>();

    public Pedido() {
        this.id = contadorId++;
    }

    public void agregarLineaPedido(LineaPedido lineaPedido){
        if (lineaPedido == null){
            throw new IllegalArgumentException("No se puede agregar una línea nula al pedido.");
        }
        this.lineaPedido.add(lineaPedido);
    }
    public double calcularTotal(){
        double total = 0;
        for (LineaPedido pedido : lineaPedido){
            total += (pedido.getCantidad() * pedido.getProducto().getPrecio());
        }
        return total;
    }

    public ArrayList<LineaPedido> getLineaPedido(){
        return lineaPedido;
    }

    public int getId(){
        return this.id;
    }
}