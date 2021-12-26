package com.sofka.vuelos.serviciopremium;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoTarea implements ValueObject<TipoTarea> {

    private final String tipo;
    private final String descripcion;

    public TipoTarea(String tipo, String descripcion){
        validateTipoTarea(tipo, descripcion);
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public String tipo() {
        return tipo;
    }

    public String descripcion() {
        return descripcion;
    }

    private void validateTipoTarea(String tipo, String descripcion){
        Objects.requireNonNull(tipo);
        Objects.requireNonNull(descripcion);
        if(tipo.isBlank()){
            throw new IllegalArgumentException("El tipo de una tarea no puede estar en blanco");
        }
        if(descripcion.isBlank()){
            throw new IllegalArgumentException("La descripcion no puede estar vacia");
        }
    }

    public TipoTarea actualizar(String tipo, String descripcion){
        validateTipoTarea(tipo, descripcion);
        return new TipoTarea(tipo, descripcion);
    }

    @Override
    public TipoTarea value() {
        return this;
    }
}
