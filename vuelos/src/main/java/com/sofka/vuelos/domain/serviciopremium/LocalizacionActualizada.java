package com.sofka.vuelos.domain.serviciopremium;

import co.com.sofka.domain.generic.DomainEvent;

public class LocalizacionActualizada extends DomainEvent {
    private final VehiculoId vehiculoId;
    private final String localizacion;

    public LocalizacionActualizada(VehiculoId vehiculoId, String localizacion) {
        super("sofka.servicio.localizacionactualizada");
        this.vehiculoId = vehiculoId;
        this.localizacion = localizacion;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public VehiculoId getVehiculoId() {
        return vehiculoId;
    }
}
