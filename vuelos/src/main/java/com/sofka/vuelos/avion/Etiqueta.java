package com.sofka.vuelos.avion;

import co.com.sofka.domain.generic.ValueObject;

public class Etiqueta implements ValueObject<Etiqueta> {

    private final Boolean delicado;
    private final String ciudadOrigen;
    private final String ciudadDestino;
    private final String inicialesNombre;

    public Etiqueta(Boolean delicado, String ciudadOrigen, String ciudadDestino, String inicialesNombre){

        this.delicado = delicado;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.inicialesNombre = inicialesNombre;
    }

    @Override
    public Etiqueta value() {
        return new Etiqueta();
    }
}
