package com.sofka.vuelos.events;

import co.com.sofka.domain.generic.DomainEvent;

public class CapacidadActualizada extends DomainEvent {

    private final Integer capacidadTotalMercancia;
    private final Integer capacidadTotalEquipaje;

    public CapacidadActualizada(Integer CapacidadTotalMercancia, Integer capacidadTotalEquipaje){
        super("sofka.vuelos.capacidadactualizada");
        capacidadTotalMercancia = CapacidadTotalMercancia;
        this.capacidadTotalEquipaje = capacidadTotalEquipaje;
    }

    public Integer getCapacidadTotalMercancia() {
        return capacidadTotalMercancia;
    }

    public Integer getCapacidadTotalEquipaje() {
        return capacidadTotalEquipaje;
    }
}
