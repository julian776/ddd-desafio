package com.sofka.vuelos.domain.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.vuelos.domain.venta.VentaId;
import com.sofka.vuelos.domain.vuelo.VueloId;

public class RealizarCambioVueloCommand extends Command {

    private final VentaId entityId;
    private final VueloId vueloId;

    public RealizarCambioVueloCommand(VentaId entityId, VueloId vueloId){
        this.entityId = entityId;
        this.vueloId = vueloId;
    }

    public VueloId getVueloId() {
        return vueloId;
    }

    public VentaId getEntityId() {
        return entityId;
    }
}
