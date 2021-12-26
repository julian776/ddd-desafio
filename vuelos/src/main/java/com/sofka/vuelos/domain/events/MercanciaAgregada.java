package com.sofka.vuelos.domain.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.vuelos.domain.vuelo.PiezaMercancia;

import java.util.List;

public class MercanciaAgregada extends DomainEvent {
    private final List<PiezaMercancia> piezas;

    public MercanciaAgregada(List<PiezaMercancia> piezas) {
        super("sofka.vuelos.mercanciaagregada");
        this.piezas = piezas;
    }

    public List<PiezaMercancia> getPiezas() {
        return piezas;
    }
}
