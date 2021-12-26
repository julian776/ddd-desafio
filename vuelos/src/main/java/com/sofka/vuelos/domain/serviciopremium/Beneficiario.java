package com.sofka.vuelos.domain.serviciopremium;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Beneficiario implements ValueObject<Beneficiario> {

    private final String nombre;
    private final Long numeroIdentificacion;
    private final Boolean activo;

    public Beneficiario(String nombre, Long numeroIdentificacion, Boolean activo){

        this.nombre = Objects.requireNonNull(nombre);
        this.numeroIdentificacion = Objects.requireNonNull(numeroIdentificacion);
        this.activo = Objects.requireNonNull(activo);
        if (nombre.isBlank()){
            throw new IllegalArgumentException("El nombre de un beneficiario no puede estar en blanco");
        }
        if(numeroIdentificacion<0){
            throw new IllegalArgumentException("El numeor de identificacion no puede ser negativo");
        }
    }

    public String nombre() {
        return nombre;
    }

    public Long numeroIdentificacion() {
        return numeroIdentificacion;
    }

    public Boolean activo() {
        return activo;
    }

    @Override
    public Beneficiario value() {
        return this;
    }
}
