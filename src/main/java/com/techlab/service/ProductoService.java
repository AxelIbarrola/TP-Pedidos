package com.techlab.service;
import com.techlab.excepciones.ProductoNoEncontradoException;
import com.techlab.productos.Producto;

import java.util.ArrayList;

public class ProductoService {
    private final ArrayList<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto){
        this.productos.add(producto);
    }

    public void mostrarProductos(){
        if (productos.isEmpty()){
            System.out.println("Lista vacia, aún no se agrego ningún producto.");
        } else {
            System.out.println("\nLista de productos: ");
            for (Producto producto : productos){
                System.out.println(producto);
            }
        }
    }

    public Producto buscarProductoPorNombre(String nombre){
        for (Producto producto : productos){
            if (producto.getNombre().equalsIgnoreCase(nombre)){
                return producto;
            }
        }

        return null;
    }

    public Producto buscarProductoPorId(int id){
        for (Producto producto : productos){
            if(producto.getId() == id){
                return producto;
            }
        }

        return null;
    }

    public void eliminarProducto(int id){
        Producto producto = this.buscarProductoPorId(id);

        if (producto == null){
            throw new ProductoNoEncontradoException("No se encontró el producto con ID: " + id);
        }

        productos.remove(producto);
    }
}