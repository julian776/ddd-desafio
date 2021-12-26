package com.sofka.vuelos.domain.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.vuelos.domain.vuelo.*;

import java.util.List;

public class CrearVueloCommand extends Command {

    private final VueloId entityId;
    private final Ruta ruta;
    private final List<Pasajero> listaPasajeros;
    private final Bodega bodega;
    private final Avion avion;

    public CrearVueloCommand(VueloId entityId, Ruta ruta, List<Pasajero> listaPasajeros, Bodega bodega, Avion avion){
        this.entityId = entityId;
        this.ruta = ruta;
        this.listaPasajeros = listaPasajeros;
        this.bodega = bodega;
        this.avion = avion;
    }

    public VueloId getEntityId() {
        return entityId;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public List<Pasajero> getListaPasajeros() {
        return listaPasajeros;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public Avion getAvion() {
        return avion;
    }
}
