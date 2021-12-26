package com.sofka.vuelos.domain.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.vuelos.domain.vuelo.Pasajero;

public class PasajeroAgregado extends DomainEvent {

    private final Pasajero pasajero;

    public PasajeroAgregado(Pasajero pasajero){
        super("sofka.vuelos.pasajeroagregado");
        this.pasajero = pasajero;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }
}
