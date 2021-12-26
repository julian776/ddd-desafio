package com.sofka.vuelos.domain.vuelo;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PiezaMercancia implements ValueObject<PiezaMercancia> {

    private final Float peso;
    private final Integer capacidadOcupada;
    private final String observaciones;
    private final Etiqueta etiqueta;

    public PiezaMercancia(Float peso, Integer capacidadOcupada, String observaciones, Etiqueta etiqueta){

        this.peso = Objects.requireNonNull(peso);
        this.capacidadOcupada = Objects.requireNonNull(capacidadOcupada);
        this.observaciones = Objects.requireNonNull(observaciones);
        this.etiqueta = Objects.requireNonNull(etiqueta);

        if(peso<0){
            throw new IllegalArgumentException("Un peso no puede ser negativo, si es despreciable use 0");
        }
        if(capacidadOcupada<0){
            throw new IllegalArgumentException("Lo que ocupa una mercancia no puede ser negativo");
        }
    }

    public Float peso() {
        return peso;
    }

    public Integer capacidadOcupada() {
        return capacidadOcupada;
    }

    public String observaciones() {
        return observaciones;
    }

    public Etiqueta etiqueta() {
        return etiqueta;
    }

    @Override
    public PiezaMercancia value() {
        return new PiezaMercancia(peso, capacidadOcupada, observaciones, etiqueta);
    }
}
