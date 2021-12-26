package com.sofka.vuelos.domain.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.vuelos.domain.vuelo.Pasajero;
import com.sofka.vuelos.domain.vuelo.VueloId;

public class AgregarPasajeroCommand extends Command {

    private final VueloId entityId;
    private final Pasajero pasajero;

    public AgregarPasajeroCommand(VueloId entityId, Pasajero pasajero){
        this.entityId = entityId;
        this.pasajero = pasajero;
    }

    public VueloId getEntityId() {
        return entityId;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }
}
