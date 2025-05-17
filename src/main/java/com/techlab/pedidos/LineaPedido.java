package com.techlab.pedidos;
import com.techlab.excepciones.CantidadInvalidaException;
import com.techlab.excepciones.ProductoInvalidoException;
import com.techlab.excepciones.StockInsuficienteException;
import com.techlab.productos.Producto;

public class LineaPedido {
    private Producto producto;
    private int cantidad;

    public LineaPedido(Producto producto, int cantidad) throws StockInsuficienteException {

        if (producto == null) {
            throw new ProductoInvalidoException("Producto no puede ser null.");
        }

        if (cantidad <= 0){
            throw new CantidadInvalidaException("Cantidad debe ser mayor a 0.");
        }

        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto(){
        return this.producto;
    }

    public int getCantidad(){
        return this.cantidad;
    }
}