package com.sofka.vuelos.avion;

import co.com.sofka.domain.generic.Entity;

import java.util.List;

public class Bodega extends Entity<BodegaId> {
    private final List<PiezaMercancia> listadoPiezasMercancia;
    private final CapacidadCarga capacidadCarga;

    public Bodega(BodegaId entityId, List<PiezaMercancia> listadoPiezasMercancia, CapacidadCarga capacidadCarga) {
        super(entityId);
        this.listadoPiezasMercancia = listadoPiezasMercancia;
        this.capacidadCarga = capacidadCarga;
    }
}
