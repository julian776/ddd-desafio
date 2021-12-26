package com.sofka.vuelos.domain.vuelo;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Etiqueta implements ValueObject<Etiqueta> {

    private final Boolean delicado;
    private final String ciudadOrigen;
    private final String ciudadDestino;
    private final String inicialesNombre;

    public Etiqueta(Boolean delicado, String ciudadOrigen, String ciudadDestino, String inicialesNombre){

        this.delicado = Objects.requireNonNull(delicado);
        this.ciudadOrigen = Objects.requireNonNull(ciudadOrigen);
        this.ciudadDestino = Objects.requireNonNull(ciudadDestino);
        this.inicialesNombre = Objects.requireNonNull(inicialesNombre);

        if(ciudadOrigen.isBlank()){
            throw new IllegalArgumentException("La ciudad de origen no puede estar en blanco");
        }
        if(ciudadDestino.isBlank()){
            throw new IllegalArgumentException("La ciudad destino no puede estar en blanco");
        }
        if (inicialesNombre.isBlank()){
            throw new IllegalArgumentException("Las iniciales no pueden estar en blanco");
        }
    }

    public Boolean delicado() {
        return delicado;
    }

    public String ciudadOrigen() {
        return ciudadOrigen;
    }

    public String ciudadDestino() {
        return ciudadDestino;
    }

    public String inicialesNombre() {
        return inicialesNombre;
    }

    @Override
    public Etiqueta value() {
        return new Etiqueta(delicado, ciudadOrigen, ciudadDestino, inicialesNombre);
    }
}
