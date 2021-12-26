package com.sofka.vuelos.serviciopremium;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofka.vuelos.events.ServicioIniciado;
import com.sofka.vuelos.events.TareaAgregada;
import com.sofka.vuelos.events.TareaFinalizada;
import com.sofka.vuelos.events.VehiculoAgregado;

import java.util.Hashtable;
import java.util.List;
import java.util.Objects;

public class ServicioPremium extends AggregateEvent<ServicioPremiumId> {

    protected Hashtable<VehiculoId, VehiculoCliente> vehiculosCliente;
    protected List<Beneficiario> beneficiarios;
    protected Hashtable<TareaId, Tarea> listadoTareas;

    public ServicioPremium(ServicioPremiumId entityId, Hashtable<VehiculoId, VehiculoCliente> vehiculosCliente,
                           List<Beneficiario> beneficiarios, Hashtable<TareaId, Tarea> listadoTareas) {
        super(entityId);
        Objects.requireNonNull(vehiculosCliente);
        Objects.requireNonNull(beneficiarios);
        Objects.requireNonNull(listadoTareas);
        appendChange(new ServicioIniciado(vehiculosCliente, beneficiarios, listadoTareas)).apply();
    }

    private ServicioPremium(ServicioPremiumId entityId){
        super(entityId);
        subscribe(new ServicioChange(this));
    }

    public void agregarTarea(Tarea tarea){
        Objects.requireNonNull(tarea);
        appendChange(new TareaAgregada(tarea)).apply();
    }

    public void agregarVehiculo(VehiculoCliente vehiculo){
        Objects.requireNonNull(vehiculo);
        appendChange(new VehiculoAgregado(vehiculo)).apply();
    }

    public void darTareaTerminda(TareaId tareaId){
        Objects.requireNonNull(tareaId);
        appendChange(new TareaFinalizada(tareaId)).apply();
    }

    public void actualizarLocalizacionVehiculo(VehiculoId vehiculoId, String localizacion){
        Objects.requireNonNull(localizacion);
        Objects.requireNonNull(vehiculoId);
        appendChange(new LocalizacionActualizada(vehiculoId, localizacion)).apply();
    }
}
