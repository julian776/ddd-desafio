package com.sofka.vuelos.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.vuelos.vuelo.PiezaMercancia;

import java.util.List;

public class MercanciaAgregadaVentas extends DomainEvent {
    private List<PiezaMercancia> piezas;

    public MercanciaAgregadaVentas(List<PiezaMercancia> piezas) {
        super("sofka.venta.mercanciaagregada");
        this.piezas = piezas;
    }

    public List<PiezaMercancia> getPiezas() {
        return piezas;
    }
}
