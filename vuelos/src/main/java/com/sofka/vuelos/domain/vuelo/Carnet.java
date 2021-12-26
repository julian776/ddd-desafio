package com.sofka.vuelos.domain.vuelo;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Carnet implements ValueObject<Carnet> {

    private final String agenciaEmisora;
    private final String[] restricciones;

    public Carnet(String agenciaEmisora, String[] restricciones){
        this.agenciaEmisora = Objects.requireNonNull(agenciaEmisora);
        this.restricciones = Objects.requireNonNull(restricciones);
        if(agenciaEmisora.isBlank()){
            throw new IllegalArgumentException("La agenciaEmisora no puede ser vacio");
        }
    }

    public String agenciaEmisora() {
        return agenciaEmisora;
    }

    public String[] restricciones() {
        return restricciones;
    }

    @Override
    public Carnet value() {
        return new Carnet(this.agenciaEmisora, this.restricciones);
    }
}
