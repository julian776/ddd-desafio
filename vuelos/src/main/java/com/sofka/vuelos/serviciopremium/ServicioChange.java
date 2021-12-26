package com.sofka.vuelos.serviciopremium;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.vuelos.events.ServicioIniciado;
import com.sofka.vuelos.events.TareaAgregada;
import com.sofka.vuelos.events.TareaFinalizada;
import com.sofka.vuelos.events.VehiculoAgregado;

public class ServicioChange extends EventChange {
    public ServicioChange(ServicioPremium servicioPremium) {

        apply((ServicioIniciado event) -> {
            servicioPremium.vehiculosCliente = event.getVehiculosCliente();
            servicioPremium.beneficiarios = event.getBeneficiarios();
            servicioPremium.listadoTareas = event.getListadoTareas();
        });

        apply((TareaAgregada event) -> {
            servicioPremium.listadoTareas.put(event.getTarea().identity(), event.getTarea());
        });

        apply((VehiculoAgregado event) -> {
           servicioPremium.vehiculosCliente.put(event.getVehiculo().identity(), event.getVehiculo());
        });

        apply((TareaFinalizada event) -> {
            servicioPremium.listadoTareas.remove(event.getTareaId());
        });

        apply((LocalizacionActualizada event) -> {
           var vehiculo = servicioPremium.vehiculosCliente.get(event.getVehiculoId());
           vehiculo.actualizarLocalizacion(event.getLocalizacion());
        });
    }
}
