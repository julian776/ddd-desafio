package com.sofka.vuelos.domain.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.vuelos.domain.serviciopremium.TareaId;

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
