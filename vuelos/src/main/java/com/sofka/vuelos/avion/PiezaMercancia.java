package com.sofka.vuelos.avion;

import co.com.sofka.domain.generic.ValueObject;

public class PiezaMercancia implements ValueObject<PiezaMercancia> {

    public PiezaMercancia(Float peso, Integer capacidadOcupada, String observaciones, Etiqueta etiqueta){

    }

    @Override
    public PiezaMercancia value() {
        return new PiezaMercancia();
    }
}
