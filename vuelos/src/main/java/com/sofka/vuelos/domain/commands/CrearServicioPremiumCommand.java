package com.sofka.vuelos.domain.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.vuelos.domain.serviciopremium.*;

import java.util.Hashtable;
import java.util.List;

public class CrearServicioPremiumCommand extends Command {

    private final ServicioPremiumId entityId;
    private final Hashtable<VehiculoId, VehiculoCliente> vehiculosCliente;
    private final List<Beneficiario> beneficiarios;
    private final Hashtable<TareaId, Tarea> listadoTareas;

    public CrearServicioPremiumCommand(ServicioPremiumId entityId, Hashtable<VehiculoId, VehiculoCliente> vehiculosCliente,
                                       List<Beneficiario> beneficiarios, Hashtable<TareaId, Tarea> listadoTareas){

        this.entityId = entityId;
        this.vehiculosCliente = vehiculosCliente;
        this.beneficiarios = beneficiarios;
        this.listadoTareas = listadoTareas;
    }

    public ServicioPremiumId getEntityId() {
        return entityId;
    }

    public Hashtable<VehiculoId, VehiculoCliente> getVehiculosCliente() {
        return vehiculosCliente;
    }

    public List<Beneficiario> getBeneficiarios() {
        return beneficiarios;
    }

    public Hashtable<TareaId, Tarea> getListadoTareas() {
        return listadoTareas;
    }
}
