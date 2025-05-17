package com.techlab.excepciones;

public class CantidadInvalidaException extends RuntimeException{
    public CantidadInvalidaException(String mensaje){
        super(mensaje);
    }
}