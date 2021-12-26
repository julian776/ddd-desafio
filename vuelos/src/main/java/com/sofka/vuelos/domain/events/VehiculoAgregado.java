package com.sofka.vuelos.domain.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.vuelos.domain.serviciopremium.VehiculoCliente;

public class VehiculoAgregado extends DomainEvent {
    private final VehiculoCliente vehiculo;

    public VehiculoAgregado(VehiculoCliente vehiculo) {
        super("sofka.servicio.vehiculoagregado");
        this.vehiculo = vehiculo;
    }

    public VehiculoCliente getVehiculo() {
        return vehiculo;
    }
}
