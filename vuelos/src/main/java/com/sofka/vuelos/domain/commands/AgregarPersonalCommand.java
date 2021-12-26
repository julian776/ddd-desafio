package com.sofka.vuelos.domain.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.vuelos.domain.vuelo.Personal;
import com.sofka.vuelos.domain.vuelo.VueloId;

public class AgregarPersonalCommand extends Command {

    private final VueloId entityId;
    private final Personal personal;

    public AgregarPersonalCommand(VueloId entityId, Personal personal){

        this.entityId = entityId;
        this.personal = personal;
    }

    public VueloId getEntityId() {
        return entityId;
    }

    public Personal getPersonal() {
        return personal;
    }
}
