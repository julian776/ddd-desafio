package com.sofka.vuelos.domain.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.vuelos.domain.serviciopremium.ServicioPremiumId;
import com.sofka.vuelos.domain.serviciopremium.VehiculoCliente;

public class AgregarVehiculoCommand extends Command {

    private final ServicioPremiumId entityId;
    private final VehiculoCliente vehiculo;

    public AgregarVehiculoCommand(ServicioPremiumId entityId, VehiculoCliente vehiculo){
        this.entityId = entityId;
        this.vehiculo = vehiculo;
    }

    public ServicioPremiumId getEntityId() {
        return entityId;
    }

    public VehiculoCliente getVehiculo() {
        return vehiculo;
    }
}
