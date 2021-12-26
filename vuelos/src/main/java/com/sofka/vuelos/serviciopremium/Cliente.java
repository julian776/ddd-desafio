package com.sofka.vuelos.serviciopremium;

import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Cliente extends Entity<ClienteId> {

    private String rangoCliente;

    public Cliente(ClienteId entityId, String rangoCliente) {
        super(entityId);
        valdiateRango(rangoCliente);
        this.rangoCliente = rangoCliente;
    }

    private void valdiateRango(String rangoCliente) {
        Objects.requireNonNull(rangoCliente);
        if(rangoCliente.isBlank()){
            throw new IllegalArgumentException("El rango no puede ser vacio");
        }
    }

    public void actualizarRango(String nuevoRango){
        valdiateRango(nuevoRango);
        this.rangoCliente = nuevoRango;
    }
}
