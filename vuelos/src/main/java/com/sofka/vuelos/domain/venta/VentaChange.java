package com.sofka.vuelos.domain.venta;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.vuelos.domain.events.FacturaGenerada;
import com.sofka.vuelos.domain.events.MercanciaAgregadaVentas;
import com.sofka.vuelos.domain.events.VentaEfectuada;
import com.sofka.vuelos.domain.events.VueloCambiado;
import com.sofka.vuelos.domain.vuelo.PiezaMercancia;

import java.util.ArrayList;

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

        apply((FacturaGenerada event) -> {
            event.getFactura().generarFactura();
        });
    }
}
