package com.sofka.vuelos.domain.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.vuelos.domain.venta.VentaId;
import com.sofka.vuelos.domain.vuelo.PiezaMercancia;

import java.util.List;

public class AgregarMercanciaVentaCommand extends Command {

    private final VentaId entityId;
    private final List<PiezaMercancia> piezas;

    public AgregarMercanciaVentaCommand(VentaId entityId, List<PiezaMercancia> piezas){
        this.entityId = entityId;
        this.piezas = piezas;
    }

    public VentaId getEntityId() {
        return entityId;
    }

    public List<PiezaMercancia> getPiezas() {
        return piezas;
    }
}
