package com.sofka.vuelos.domain.vuelo;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CapacidadCarga implements ValueObject<CapacidadCarga> {

    private final Integer capacidadTotalMercancia;
    private final Integer capacidadTotalEquipaje;
    private final Integer capacidadOcupadaMercancia;
    private final Integer capacidadOcupadaEquipaje;

    public CapacidadCarga(Integer capacidadTotalMercancia, Integer capacidadTotalEquipaje, Integer capacidadOcupadaMercancia, Integer capacidadOcupadaEquipaje){

        this.capacidadTotalMercancia = Objects.requireNonNull(capacidadTotalMercancia);
        this.capacidadTotalEquipaje = Objects.requireNonNull(capacidadTotalEquipaje);
        this.capacidadOcupadaMercancia = Objects.requireNonNull(capacidadOcupadaMercancia);
        this.capacidadOcupadaEquipaje = Objects.requireNonNull(capacidadOcupadaEquipaje);
        validateCapacity(capacidadTotalMercancia, capacidadTotalEquipaje, capacidadOcupadaMercancia, capacidadOcupadaEquipaje);
    }

    private void validateCapacity(Integer capacidadTotalMercancia, Integer capacidadTotalEquipaje, Integer capacidadOcupadaMercancia, Integer capacidadOcupadaEquipaje) {
        if(capacidadTotalMercancia<capacidadOcupadaMercancia){
            throw new IllegalArgumentException("La capacidad de la mercancia no puede superar la capacidad ocupada");
        }
        if(capacidadTotalEquipaje<capacidadOcupadaEquipaje){
            throw new IllegalArgumentException("La capacidad del equipaje no puede superar la capacidad ocupada");
        }
    }

    public Integer capacidadTotalMercancia() {
        return capacidadTotalMercancia;
    }

    public Integer capacidadTotalEquipaje() {
        return capacidadTotalEquipaje;
    }

    public Integer capacidadOcupadaMercancia() {
        return capacidadOcupadaMercancia;
    }

    public Integer capacidadOcupadaEquipaje() {
        return capacidadOcupadaEquipaje;
    }

    @Override
    public CapacidadCarga value() {
        return new CapacidadCarga(capacidadTotalMercancia, capacidadTotalEquipaje, capacidadOcupadaMercancia, capacidadOcupadaEquipaje);
    }

    public CapacidadCarga actualizarCapacidad(Integer capacidadTotalMercancia, Integer capacidadTotalEquipaje) {
        validateCapacity(capacidadTotalMercancia, capacidadTotalEquipaje, capacidadOcupadaMercancia, capacidadOcupadaEquipaje);
        return new CapacidadCarga(capacidadTotalMercancia, capacidadTotalEquipaje, this.capacidadOcupadaMercancia, this.capacidadOcupadaEquipaje);
    }
}
