package com.sofka.vuelos.venta;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofka.vuelos.events.MercanciaAgregadaVentas;
import com.sofka.vuelos.events.VentaEfectuada;
import com.sofka.vuelos.events.VueloCambiado;
import com.sofka.vuelos.vuelo.PiezaMercancia;
import com.sofka.vuelos.vuelo.VueloId;

import java.util.List;
import java.util.Objects;

public class Venta extends AggregateEvent<VentaId> {

    protected Factura factura;
    protected VueloId vueloId;
    protected Tiquete tiquete;
    protected Mercancia mercancia;

    public Venta(VentaId entityId, Factura factura, VueloId vueloId, Tiquete tiquete, Mercancia mercancia) {
        super(entityId);

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

    public void generarFactura(){
        factura.generarFactura();
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
}
