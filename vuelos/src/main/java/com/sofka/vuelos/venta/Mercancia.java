package com.sofka.vuelos.venta;

import co.com.sofka.domain.generic.Entity;
import com.sofka.vuelos.vuelo.PiezaMercancia;

import java.util.List;
import java.util.Objects;

public class Mercancia extends Entity<MercanciaId> {

    private final List<PiezaMercancia> piezasMercancia;
    private Boolean asegurado;
    private Integer cantidad;
    private Integer pesoTotal;
    private Integer capacidadTotalOcupada;

    public Mercancia(MercanciaId entityId, Boolean asegurado, List<PiezaMercancia> piezasMercancia) {
        super(entityId);
        this.asegurado = Objects.requireNonNull(asegurado);
        Objects.requireNonNull(cantidad);
        Objects.requireNonNull(pesoTotal);
        Objects.requireNonNull(capacidadTotalOcupada);
        this.piezasMercancia = Objects.requireNonNull(piezasMercancia);

        this.cantidad = piezasMercancia.size();
        this.pesoTotal = calcularPesoTotal(piezasMercancia);
        this.capacidadTotalOcupada = calcularCapacidadOcupada(piezasMercancia);

        if(cantidad<0){
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
        if(pesoTotal<0){
            throw new IllegalArgumentException("El peso no puede ser negativo");
        }
        if (capacidadTotalOcupada<0){
            throw new IllegalArgumentException("La capacidad ocupada no puede ser negativo");
        }
    }

    public void agregarMercancia(List<PiezaMercancia> piezasAgregar){
        piezasMercancia.addAll(piezasAgregar);
    }

    private Integer calcularCapacidadOcupada(List<PiezaMercancia> piezasMercancia) {
        Objects.requireNonNull(piezasMercancia);
        return piezasMercancia.stream().reduce(0, (subtotal, pieza) -> subtotal + pieza.capacidadOcupada(), Integer::sum);
    }

    private Integer calcularPesoTotal(List<PiezaMercancia> piezasMercancia) {
        Objects.requireNonNull(piezasMercancia);
        return piezasMercancia.stream().reduce(0, (peso, pieza) -> peso + pieza.capacidadOcupada(), Integer::sum);
    }

    public void listarMercancia(){
        piezasMercancia.forEach(System.out::println);
    }
}
