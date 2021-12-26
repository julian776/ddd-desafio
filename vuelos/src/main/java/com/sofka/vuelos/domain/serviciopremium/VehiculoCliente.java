package com.sofka.vuelos.domain.serviciopremium;

import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class VehiculoCliente extends Entity<VehiculoId> {

    private String localizacion;
    private InformacionVehiculo informacionVehiculo;

    public VehiculoCliente(VehiculoId entityId, String localizacion, InformacionVehiculo informacionVehiculo) {
        super(entityId);
        this.localizacion = Objects.requireNonNull(localizacion);
        this.informacionVehiculo = Objects.requireNonNull(informacionVehiculo);
        if (localizacion.isBlank()){
            throw new IllegalArgumentException("La localizacion no puede estar vacia");
        }
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public InformacionVehiculo getInformacionVehiculo() {
        return informacionVehiculo;
    }

    public void actualizarInformacion(String tipo, Long numeroSerie, Long identificador, String combustible){
        this.informacionVehiculo = this.informacionVehiculo.actualizar(tipo, numeroSerie, identificador, combustible);
    }

    public void actualizarLocalizacion(String localizacion){
        this.localizacion = Objects.requireNonNull(localizacion);
        if(localizacion.isBlank()){
            throw new IllegalArgumentException("La localizacion no puede estar vacia");
        }
    }
}
