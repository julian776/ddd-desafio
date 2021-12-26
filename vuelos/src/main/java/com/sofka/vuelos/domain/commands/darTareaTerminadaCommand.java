package com.sofka.vuelos.domain.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.vuelos.domain.serviciopremium.ServicioPremiumId;
import com.sofka.vuelos.domain.serviciopremium.TareaId;

public class darTareaTerminadaCommand extends Command {

    private final ServicioPremiumId entityId;
    private final TareaId tareaId;

    public darTareaTerminadaCommand(ServicioPremiumId entityId, TareaId tareaId){
        this.entityId = entityId;
        this.tareaId = tareaId;
    }

    public ServicioPremiumId getEntityId() {
        return entityId;
    }

    public TareaId getTareaId() {
        return tareaId;
    }
}
