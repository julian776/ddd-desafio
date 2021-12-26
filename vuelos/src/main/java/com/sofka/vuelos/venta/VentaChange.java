package com.sofka.vuelos.venta;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.vuelos.events.MercanciaAgregadaVentas;
import com.sofka.vuelos.events.VentaEfectuada;
import com.sofka.vuelos.events.VueloCambiado;

public class VentaChange extends EventChange {
    public VentaChange(Venta venta) {

        apply((VentaEfectuada event) -> {
            venta.factura = event.getFactura();
            venta.vueloId = event.getVueloId();
            venta.tiquete = event.getTiquete();
            venta.mercancia = event.getMercancia();
        });

        apply((MercanciaAgregadaVentas event) -> {
            venta.mercancia.agregarMercancia(event.getPiezas());
        });

        apply((VueloCambiado event) -> {
            venta.tiquete.cambiarVuelo(event.getVueloId());
        });
    }
}
