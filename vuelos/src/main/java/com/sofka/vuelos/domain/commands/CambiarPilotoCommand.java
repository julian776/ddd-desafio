package com.sofka.vuelos.domain.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.vuelos.domain.vuelo.Piloto;
import com.sofka.vuelos.domain.vuelo.VueloId;

public class CambiarPilotoCommand extends Command {

    private final VueloId entityId;
    private final Piloto piloto;

    public CambiarPilotoCommand(VueloId entityId, Piloto piloto){

        this.entityId = entityId;
        this.piloto = piloto;
    }

    public VueloId getEntityId() {
        return entityId;
    }

    public Piloto getPiloto() {
        return piloto;
    }
}
