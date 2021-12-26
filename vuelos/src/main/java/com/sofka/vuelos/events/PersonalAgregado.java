package com.sofka.vuelos.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.vuelos.vuelo.Personal;

public class PersonalAgregado extends DomainEvent {
    private final Personal personal;

    public PersonalAgregado(Personal personal) {
        super("sofka.vuelos.personalagregado");

        this.personal = personal;
    }

    public Personal getPersonal() {
        return personal;
    }
}
