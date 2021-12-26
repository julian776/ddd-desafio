package com.sofka.vuelos.domain.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.vuelos.domain.vuelo.PiezaMercancia;
import com.sofka.vuelos.domain.vuelo.VueloId;

import java.util.List;

public class AgregarMercanciaCommand extends Command {

    private final VueloId entityId;
    private final List<PiezaMercancia> piezas;

    public AgregarMercanciaCommand(VueloId entityId, List<PiezaMercancia> piezas){
        this.entityId = entityId;
        this.piezas = piezas;
    }

    public VueloId getEntityId() {
        return entityId;
    }

    public List<PiezaMercancia> getPiezas() {
        return piezas;
    }
}
