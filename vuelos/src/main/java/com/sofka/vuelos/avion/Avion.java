package com.sofka.vuelos.avion;

import co.com.sofka.domain.generic.Entity;

import java.util.List;

public class Avion extends Entity<AvionId> {
    private Piloto piloto;
    private Bodega bodega;
    private List<Personal> listaPersonal;

    public Avion(AvionId entityId, Piloto piloto, Bodega bodega, List<Personal> listaPersonal) {
        super(entityId);
        this.piloto = piloto;
        this.bodega = bodega;
        this.listaPersonal = listaPersonal;
    }
}
