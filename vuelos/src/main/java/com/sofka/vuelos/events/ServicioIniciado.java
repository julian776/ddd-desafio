package com.sofka.vuelos.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.vuelos.serviciopremium.*;

import java.util.Hashtable;
import java.util.List;

public class ServicioIniciado extends DomainEvent {
    private final Hashtable<VehiculoId, VehiculoCliente> vehiculosCliente;
    private final List<Beneficiario> beneficiarios;
    private final Hashtable<TareaId, Tarea> listadoTareas;

    public ServicioIniciado(Hashtable<VehiculoId, VehiculoCliente> vehiculosCliente, List<Beneficiario> beneficiarios, Hashtable<TareaId, Tarea> listadoTareas) {
        super("sofka.servicio.servicioiniciado");
        this.vehiculosCliente = vehiculosCliente;
        this.beneficiarios = beneficiarios;
        this.listadoTareas = listadoTareas;
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
