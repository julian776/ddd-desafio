package com.sofka.vuelos.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.vuelos.vuelo.Avion;
import com.sofka.vuelos.vuelo.Bodega;
import com.sofka.vuelos.vuelo.Pasajero;
import com.sofka.vuelos.vuelo.Ruta;

import java.util.List;
import java.util.Objects;

public class VueloCreado extends DomainEvent {
    private final Ruta ruta;
    private final List<Pasajero> listaPasajeros;
    private final Bodega bodega;
    private final Avion avion;

    public VueloCreado(Ruta ruta, List<Pasajero> listaPasajeros, Bodega bodega, Avion avion) {
        super("sofka.vuelos.vuelocreado");

        this.ruta = Objects.requireNonNull(ruta);
        this.listaPasajeros = Objects.requireNonNull(listaPasajeros);
        this.bodega = Objects.requireNonNull(bodega);
        this.avion = Objects.requireNonNull(avion);
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
