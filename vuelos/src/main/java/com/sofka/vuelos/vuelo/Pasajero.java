package com.sofka.vuelos.vuelo;

import co.com.sofka.domain.generic.Entity;
import com.sofka.vuelos.Sexo;

import java.util.Objects;

public class Pasajero extends Entity<PasajeroId> {

    private Identificacion identificacion;

    public Pasajero(PasajeroId entityId, Identificacion identificacion) {
        super(entityId);
        this.identificacion = Objects.requireNonNull(identificacion);
    }

    public void actualizarSexo(Sexo sexo){
        this.identificacion = identificacion.actualizarSexo(sexo);
    }

    public void actualizarEdad(Integer edad){
        this.identificacion = identificacion.actualizarEdad(edad);
    }
}
