package com.sofka.vuelos.domain.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.vuelos.domain.serviciopremium.ServicioPremiumId;
import com.sofka.vuelos.domain.serviciopremium.Tarea;

public class AgregarTareaCommand extends Command {

    private final ServicioPremiumId entityId;
    private final Tarea tarea;

    public AgregarTareaCommand(ServicioPremiumId entityId, Tarea tarea){

        this.entityId = entityId;
        this.tarea = tarea;
    }

    public ServicioPremiumId getEntityId() {
        return entityId;
    }

    public Tarea getTarea() {
        return tarea;
    }
}
