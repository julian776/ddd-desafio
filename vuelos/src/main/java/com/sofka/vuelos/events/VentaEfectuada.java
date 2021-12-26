package com.sofka.vuelos.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.vuelos.venta.Factura;
import com.sofka.vuelos.venta.Mercancia;
import com.sofka.vuelos.venta.Tiquete;
import com.sofka.vuelos.venta.VentaId;
import com.sofka.vuelos.vuelo.VueloId;

public class VentaEfectuada extends DomainEvent {
    private VentaId entityId;
    private Factura factura;
    private VueloId vueloId;
    private Tiquete tiquete;
    private Mercancia mercancia;

    public VentaEfectuada(VentaId entityId, Factura factura, VueloId vueloId, Tiquete tiquete, Mercancia mercancia) {
        super("sofka.venta.ventaefectuada");
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
