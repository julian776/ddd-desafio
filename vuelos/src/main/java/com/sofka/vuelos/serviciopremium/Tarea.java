package com.sofka.vuelos.serviciopremium;

import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Tarea extends Entity<TareaId> {
    private String ciudadOrigen;
    private String ciudadDestino;
    private TipoTarea tipoTarea;
    private VehiculoCliente vehiculoCliente;

    public Tarea(TareaId entityId, String ciudadOrigen, String ciudadDestino, TipoTarea tipoTarea, VehiculoCliente vehiculoCliente) {
        super(entityId);
        this.ciudadOrigen = Objects.requireNonNull(ciudadOrigen);
        this.ciudadDestino = Objects.requireNonNull(ciudadDestino);
        this.tipoTarea = tipoTarea;
        this.vehiculoCliente = Objects.requireNonNull(vehiculoCliente);
        if(ciudadOrigen.isBlank()){
            throw new IllegalArgumentException("La ciudad origen no puede estar en blanco");
        }
        if(ciudadDestino.isBlank()){
            throw new IllegalArgumentException("La ciudad destino no puede estar en blanco");
        }
    }

    public void actualizarTipoTarea(String tipo, String descripcion){
        this.tipoTarea = tipoTarea.actualizar(tipo, descripcion);
    }

    public void cambiarDestino(String ciudadDestino){
        Objects.requireNonNull(ciudadDestino);
        if (ciudadDestino.isBlank()){
            throw new IllegalArgumentException("La ciudad de destino no puede estar en blanco");
        }
        this.ciudadDestino = ciudadDestino;
    }
}
