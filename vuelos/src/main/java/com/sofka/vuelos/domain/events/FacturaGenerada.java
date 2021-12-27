package com.sofka.vuelos.domain.events;

import com.sofka.vuelos.domain.venta.Factura;

public class FacturaGenerada extends co.com.sofka.domain.generic.DomainEvent {


    private final Factura factura;

    public FacturaGenerada(Factura factura) {
        super("sofka.venta.facturagenerada");
        this.factura = factura;
    }

    public Factura getFactura() {
        return factura;
    }
}
