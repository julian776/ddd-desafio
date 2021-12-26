package com.sofka.vuelos.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.vuelos.serviciopremium.Tarea;

public class TareaAgregada extends DomainEvent {
    private final Tarea tarea;

    public TareaAgregada(Tarea tarea) {
        super("sofka.servicio.tareaagregada");
        this.tarea = tarea;
    }

    public Tarea getTarea() {
        return tarea;
    }
}
