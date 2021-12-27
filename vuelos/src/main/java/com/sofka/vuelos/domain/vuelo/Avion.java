package com.sofka.vuelos.domain.vuelo;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.Entity;

import java.util.List;
import java.util.Objects;

public class Avion extends Entity<AvionId> {
    private Piloto piloto;
    private Bodega bodega;
    private List<Personal> listaPersonal;

    public Avion(AvionId entityId, Piloto piloto, List<Personal> listaPersonal) {
        super(entityId);
        this.piloto = Objects.requireNonNull(piloto);
        this.listaPersonal = Objects.requireNonNull(listaPersonal);
    }

    public void cambiarPiloto(Piloto nuevoPiloto){
        Objects.requireNonNull(nuevoPiloto);
        this.piloto = nuevoPiloto;
    }

    public void agregarPersonal(Personal personal){
        Objects.requireNonNull(personal);
        this.listaPersonal.add(personal);
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public List<Personal> getListaPersonal() {
        return listaPersonal;
    }
}
