package com.sofka.vuelos.domain.vuelo;

import co.com.sofka.domain.generic.Entity;

import java.util.List;
import java.util.Objects;

public class Bodega extends Entity<BodegaId> {
    private final List<PiezaMercancia> listadoPiezasMercancia;
    private CapacidadCarga capacidadCarga;

    public Bodega(BodegaId entityId, List<PiezaMercancia> listadoPiezasMercancia, CapacidadCarga capacidadCarga) {
        super(entityId);
        this.capacidadCarga = Objects.requireNonNull(capacidadCarga);
        this.listadoPiezasMercancia = Objects.requireNonNull(listadoPiezasMercancia);
    }

    public void agregarMercancia(List<PiezaMercancia> piezasAgregar){
        Objects.requireNonNull(piezasAgregar);
        piezasAgregar.forEach(this.listadoPiezasMercancia::add);
    }

    public void actualizarCapacidadCarga(Integer capacidadTotalMercancia, Integer capacidaTotalEquipaje){
        this.capacidadCarga = capacidadCarga.actualizarCapacidad(capacidadTotalMercancia, capacidaTotalEquipaje);
    }
}
