package com.RealParking.service;

public class PermisosException extends RuntimeException {

    public PermisosException(String mensaje) {
        super(mensaje);
    }

    public PermisosException(String message, Throwable cause) {
        super(message, cause);
    }

}
