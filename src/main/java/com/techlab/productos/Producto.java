package com.techlab.productos;

import com.techlab.excepciones.NombreInvalidoException;
import com.techlab.excepciones.PrecioInvalidoException;
import com.techlab.excepciones.StockInsuficienteException;
import com.techlab.excepciones.StockInvalidoException;

public class Producto {
    private String nombre;
    private double precio;
    private int stock;
    private final int id;
    private static int contadorId = 1;

    public Producto(String nombre, double precio, int stock) {

        this.setNombre(nombre);
        this.setPrecio(precio);
        this.setStock(stock);
        this.id = contadorId++;
    }

    public void reducirStock(int cantidad) throws StockInsuficienteException{
        if (cantidad > this.stock){
            throw new StockInsuficienteException("Stock insuficiente.");
        }
        this.stock -= cantidad;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Nombre: " + nombre +
                " | Precio: $" + precio +
                " | Stock: " + stock;
    }

    public void setNombre(String nombre){
        if (nombre == null || nombre.isBlank()){
            throw new NombreInvalidoException("Nombre inválido: " + nombre + ". El nombre no puede estar vacío." );
        }
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setPrecio(double precio){
        if (precio < 0){
            throw new PrecioInvalidoException("Precio inválido: " + precio + ". El precio debe ser un número positivo.");
        }
        this.precio = precio;
    }

    public double getPrecio(){
        return precio;
    }

    public void setStock(int stock){
        if (stock < 0) {
            throw new StockInvalidoException("Stock inválido: " + stock + ". El stock debe ser un número positivo.");
        }
        this.stock = stock;
    }

    public int getStock(){
        return this.stock;
    }

    public int getId(){
        return this.id;
    }
}