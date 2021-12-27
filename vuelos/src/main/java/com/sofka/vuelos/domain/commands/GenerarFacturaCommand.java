package com.sofka.vuelos.domain.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.vuelos.domain.venta.*;
import com.sofka.vuelos.domain.vuelo.VueloId;

public class GenerarFacturaCommand extends Command {

    private final VentaId entityId;
    private final Factura factura;
    private final VueloId vueloId;
    private final Tiquete tiquete;
    private final Mercancia mercancia;

    public GenerarFacturaCommand(VentaId entityId, Factura factura, VueloId vueloId, Tiquete tiquete, Mercancia mercancia) {

        this.entityId = entityId;
        this.factura = factura;
        this.vueloId = vueloId;
        this.tiquete = tiquete;
        this.mercancia = mercancia;
    }

    public VentaId getEntityId() {
        return entityId;
    }

    public Factura getFactura() {
        return factura;
    }

    public VueloId getVueloId() {
        return vueloId;
    }

    public Tiquete getTiquete() {
        return tiquete;
    }

    public Mercancia getMercancia() {
        return mercancia;
    }
}
