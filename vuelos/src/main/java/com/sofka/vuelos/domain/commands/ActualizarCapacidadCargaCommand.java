package com.sofka.vuelos.domain.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.vuelos.domain.vuelo.VueloId;

public class ActualizarCapacidadCargaCommand extends Command {

    private final VueloId entityId;
    private final Integer capacidadTotalMercancia;
    private final Integer capacidadTotalEquipaje;

    public ActualizarCapacidadCargaCommand(VueloId entityId, Integer capacidadTotalMercancia, Integer capacidadTotalEquipaje){
        this.entityId = entityId;
        this.capacidadTotalMercancia = capacidadTotalMercancia;
        this.capacidadTotalEquipaje = capacidadTotalEquipaje;
    }

    public VueloId getEntityId() {
        return entityId;
    }

    public Integer getCapacidadTotalMercancia() {
        return capacidadTotalMercancia;
    }

    public Integer getCapacidadTotalEquipaje() {
        return capacidadTotalEquipaje;
    }
}
