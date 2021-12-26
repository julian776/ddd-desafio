package com.sofka.vuelos.domain.serviciopremium;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class InformacionVehiculo implements ValueObject<InformacionVehiculo> {

    private final String tipo;
    private final Long numeroSerie;
    private final Long identificador;
    private final String combustible;

    public InformacionVehiculo(String tipo, Long numeroSerie, Long identificador, String combustible){

        this.tipo = Objects.requireNonNull(tipo);
        this.numeroSerie = Objects.requireNonNull(numeroSerie);
        this.identificador = Objects.requireNonNull(identificador);
        this.combustible = Objects.requireNonNull(combustible);
        if(tipo.isBlank()){
            throw new IllegalArgumentException("El tipo de vehiculo no puede estar en blanco");
        }
        if(numeroSerie<0){
            throw new IllegalArgumentException("El numero de serie no puede se negativo");
        }
        if(identificador<0){
            throw new IllegalArgumentException("El identificador no puede ser negativo");
        }
        if(combustible.isBlank()){
            throw new IllegalArgumentException("El combustible no puede estar en blanco");
        }
    }

    public String tipo() {
        return tipo;
    }

    public Long numeroSerie() {
        return numeroSerie;
    }

    public Long identificador() {
        return identificador;
    }

    public String combustible() {
        return combustible;
    }

    public InformacionVehiculo actualizar(String tipo, Long numeroSerie, Long identificador, String combustible){
        return new InformacionVehiculo(tipo, numeroSerie, identificador, combustible);
    }

    @Override
    public InformacionVehiculo value() {
        return this;
    }
}
