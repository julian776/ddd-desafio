package com.sofka.vuelos.vuelo;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Ruta implements ValueObject<Ruta> {

    private final String origen;
    private final String destino;
    private final String[] paradas;

    public Ruta(String origen, String destino, String[] paradas){

        this.origen = Objects.requireNonNull(origen);
        this.destino = Objects.requireNonNull(destino);
        this.paradas = Objects.requireNonNull(paradas);
        if(origen.isBlank()){
            throw new IllegalArgumentException("La ciudad de origen no puede estar vacio");
        }
        if(destino.isBlank()){
            throw new IllegalArgumentException("La ciudad de origen no puede estar vacio");
        }
    }

    public String origen() {
        return origen;
    }

    public String destino() {
        return destino;
    }

    public String[] paradas() {
        return paradas;
    }

    @Override
    public Ruta value() {
        return this;
    }
}
