package com.sofka.vuelos.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.vuelos.serviciopremium.TareaId;

public class TareaFinalizada extends DomainEvent {
    private final TareaId tareaId;

    public TareaFinalizada(TareaId tareaId) {
        super("sofka.servicio.tareafinalizada");
        this.tareaId = tareaId;
    }

    public TareaId getTareaId() {
        return tareaId;
    }
}
