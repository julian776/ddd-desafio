package com.sofka.vuelos.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.vuelos.vuelo.Piloto;

public class PilotoCambiado extends DomainEvent {
    private final Piloto piloto;

    public PilotoCambiado(Piloto piloto) {
        super("sofka.vuelos.pilotocambiado");
        this.piloto = piloto;
    }

    public Piloto getPiloto() {
        return piloto;
    }
}
