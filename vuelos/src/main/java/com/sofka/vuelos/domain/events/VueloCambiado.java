package com.sofka.vuelos.domain.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.vuelos.domain.vuelo.VueloId;

public class VueloCambiado extends DomainEvent {
    private VueloId vueloId;

    public VueloCambiado(VueloId vueloId) {
        super("sofka.venta.vuelocambiado");
        this.vueloId = vueloId;
    }

    public VueloId getVueloId() {
        return vueloId;
    }
}
