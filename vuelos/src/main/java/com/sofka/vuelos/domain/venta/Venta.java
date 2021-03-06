package com.sofka.vuelos.domain.venta;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.vuelos.domain.events.FacturaGenerada;
import com.sofka.vuelos.domain.events.MercanciaAgregadaVentas;
import com.sofka.vuelos.domain.events.VentaEfectuada;
import com.sofka.vuelos.domain.events.VueloCambiado;
import com.sofka.vuelos.domain.vuelo.PiezaMercancia;
import com.sofka.vuelos.domain.vuelo.VueloId;

import java.util.List;
import java.util.Objects;

public class Venta extends AggregateEvent<VentaId> {

    protected Factura factura;
    protected VueloId vueloId;
    protected Tiquete tiquete;
    protected Mercancia mercancia;

    public Venta(VentaId entityId, Factura factura, VueloId vueloId, Tiquete tiquete, Mercancia mercancia) {
        super(entityId);
        subscribe(new VentaChange(this));
        Objects.requireNonNull(factura);
        Objects.requireNonNull(vueloId);
        Objects.requireNonNull(tiquete);
        Objects.requireNonNull(mercancia);
        appendChange(new VentaEfectuada(entityId, factura, vueloId, tiquete, mercancia)).apply();
    }

    private Venta(VentaId entityId){
        super(entityId);
        subscribe(new VentaChange(this));
    }

    public static Venta from(VentaId entityId, List<DomainEvent> domainEvents) {
        var venta = new Venta(entityId);
        domainEvents.forEach(venta::applyEvent);
        return venta;
    }

    public void generarFactura(){
        appendChange(new FacturaGenerada(this.factura)).apply();
    }

    public void generarTiquete(){
        tiquete.generarTiquete();
    }

    public void agregarMercanciaVenta(List<PiezaMercancia> piezas){
        Objects.requireNonNull(piezas);
        appendChange(new MercanciaAgregadaVentas(piezas)).apply();
    }

    public void realiarCambioVuelo(VueloId vueloId){
        Objects.requireNonNull(vueloId);
        appendChange(new VueloCambiado(vueloId)).apply();
    }

    public void listarMercancia(){
        this.mercancia.listarMercancia();
    }

    public Factura getFactura() {
        return factura;
    }

    public VueloId getVueloId() {
        return vueloId;
    }

    public Tiquete getTiquete() {
        return tiquete;
    }

    public Mercancia getMercancia() {
        return mercancia;
    }
}
