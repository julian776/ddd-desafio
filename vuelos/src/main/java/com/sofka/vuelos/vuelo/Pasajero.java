package com.sofka.vuelos.vuelo;

import co.com.sofka.domain.generic.Entity;
import com.sofka.vuelos.Sexo;

import java.util.Objects;

public class Pasajero extends Entity<PasajeroId> {

    private Identificacion identificacion;
    private CuidadosExtra cuidadosExtra;

    public Pasajero(PasajeroId entityId, Identificacion identificacion, CuidadosExtra cuidadosExtra) {
        super(entityId);
        this.identificacion = Objects.requireNonNull(identificacion);
        this.cuidadosExtra = Objects.requireNonNull(cuidadosExtra);
    }

    public void actualizarSexo(Sexo sexo){
        this.identificacion = identificacion.actualizarSexo(sexo);
    }

    public void actualizarEdad(Integer edad){
        this.identificacion = identificacion.actualizarEdad(edad);
    }

    public void actualizarCuidados(Boolean oxigeno, Boolean embarazo, Boolean mareo, Boolean bebe){
        this.cuidadosExtra = cuidadosExtra.actualizar(oxigeno, embarazo, mareo, bebe);
    }
}
