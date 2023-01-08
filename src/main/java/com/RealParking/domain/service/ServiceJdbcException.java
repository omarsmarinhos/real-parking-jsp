package com.RealParking.domain.service;

public class ServiceJdbcException extends RuntimeException{

    public ServiceJdbcException(String mensaje) {
        super(mensaje);
    }

    public ServiceJdbcException(String message, Throwable cause) {
        super(message, cause);
    }
}
