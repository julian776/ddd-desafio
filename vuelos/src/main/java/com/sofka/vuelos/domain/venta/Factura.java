package com.sofka.vuelos.domain.venta;

import co.com.sofka.domain.generic.Entity;
import com.sofka.vuelos.domain.vuelo.Identificacion;

import java.util.Objects;

public class Factura extends Entity<FacturaId> {

    private Identificacion identificacion;
    private Double total;

    public Factura(FacturaId entityId, Identificacion identificacion, Double total) {
        super(entityId);
        this.identificacion = Objects.requireNonNull(identificacion);
        this.total = Objects.requireNonNull(total);

        if (total < 0) {
            throw new IllegalArgumentException("El total no puede ser negativo");
        }
    }

    public void actualizarTotal(Double cantidadAumentada) {
        this.total += cantidadAumentada;
    }

    public void generarFactura() {
        System.out.println("Factura numero " + entityId);
        System.out.println("Usuario " + identificacion.nombre());
        System.out.println("Documento " + identificacion.numeroIdentificacion());
        System.out.println("De edad " + identificacion.edad());
        System.out.println("Total: " + this.total);
    }

    public Identificacion getIdentificacion() {
        return identificacion;
    }

    public Double getTotal() {
        return total;
    }
}
