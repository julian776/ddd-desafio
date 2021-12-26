package com.sofka.vuelos.domain.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.vuelos.domain.serviciopremium.ServicioPremiumId;
import com.sofka.vuelos.domain.serviciopremium.VehiculoId;

public class ActualizarLocalizacionVehiculoCommand extends Command {

    private final ServicioPremiumId entityId;
    private final VehiculoId vehiculoId;
    private final String localizacion;

    public ActualizarLocalizacionVehiculoCommand(ServicioPremiumId entityId, VehiculoId vehiculoId, String localizacion){
        this.entityId = entityId;
        this.vehiculoId = vehiculoId;
        this.localizacion = localizacion;
    }

    public ServicioPremiumId getEntityId() {
        return entityId;
    }

    public VehiculoId getVehiculoId() {
        return vehiculoId;
    }

    public String getLocalizacion() {
        return localizacion;
    }
}
