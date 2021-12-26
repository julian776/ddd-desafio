package com.sofka.vuelos.domain.vuelo;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofka.vuelos.domain.events.*;

import java.util.List;
import java.util.Objects;

public class Vuelo extends AggregateEvent<VueloId> {

    protected Ruta ruta;
    protected List<Pasajero> listaPasajeros;
    protected Bodega bodega;
    protected Avion avion;

    public Vuelo(VueloId entityId, Ruta ruta, List<Pasajero> listaPasajeros, Bodega bodega, Avion avion) {
        super(entityId);
        appendChange(new VueloCreado(ruta, listaPasajeros, bodega, avion)).apply();
    }

    private Vuelo(VueloId entityId){
        super(entityId);
        subscribe(new VueloChange(this));
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

    public void agregarPasajero(Pasajero pasajero){
        Objects.requireNonNull(pasajero);
        appendChange(new PasajeroAgregado(pasajero)).apply();
    }

    public void agregarMercancia(List<PiezaMercancia> piezas){
        Objects.requireNonNull(piezas);
        appendChange(new MercanciaAgregada(piezas)).apply();
    }

    public void actualizarCapacidadCarga(Integer capacidadTotalMercancia, Integer capacidadTotalEquipaje){
        appendChange(new CapacidadActualizada(capacidadTotalMercancia, capacidadTotalEquipaje)).apply();
    }

    public void cambiarPiloto(Piloto piloto){
        Objects.requireNonNull(piloto);
        appendChange(new PilotoCambiado(piloto)).apply();
    }

    public void agregarPersonal(Personal personal){
        Objects.requireNonNull(personal);
        appendChange(new PersonalAgregado(personal)).apply();
    }
}
