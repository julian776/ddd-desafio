package com.sofka.vuelos.domain.vuelo;

import com.sofka.vuelos.domain.events.*;

public class VueloChange extends co.com.sofka.domain.generic.EventChange {

    public VueloChange(Vuelo vuelo){

        apply((VueloCreado event) -> {
            vuelo.ruta = event.getRuta();
            vuelo.listaPasajeros = event.getListaPasajeros();
            vuelo.bodega = event.getBodega();
            vuelo.avion = event.getAvion();
        });

        apply((PasajeroAgregado event) -> {
            vuelo.listaPasajeros.add(event.getPasajero());
        });

        apply((MercanciaAgregada event) -> {
            vuelo.bodega.agregarMercancia(event.getPiezas());
        });

        apply((PilotoCambiado event) -> {
            vuelo.avion.cambiarPiloto(event.getPiloto());
        });

        apply((PersonalAgregado event) -> {
            vuelo.avion.agregarPersonal(event.getPersonal());
        });
    }
}
