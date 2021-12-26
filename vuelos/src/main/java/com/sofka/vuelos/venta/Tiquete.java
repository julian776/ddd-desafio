package com.sofka.vuelos.venta;

import co.com.sofka.domain.generic.Entity;
import com.sofka.vuelos.RepositoryTest;
import com.sofka.vuelos.vuelo.Ruta;
import com.sofka.vuelos.vuelo.VueloId;

import java.util.Objects;

public class Tiquete extends Entity<TiqueteId> {

    private RepositoryTest repository;
    private Ruta ruta;
    private VueloId vueloId;

    public Tiquete(TiqueteId entityId, Ruta ruta, VueloId vueloId) {
        super(entityId);
        this.ruta = Objects.requireNonNull(ruta);
        this.vueloId = Objects.requireNonNull(vueloId);
    }

    public void cambiarVuelo(VueloId vueloId) {
        this.vueloId = vueloId;
        try {
            this.ruta = repository.getVueloById(vueloId).getRuta(); //TODO:crear metodo para los tiquetes(No es momento de usarlo, solo crear un mockito que que queme un vuelo// ).
        }catch(Exception e){
            System.out.println("No fue posible cambiar el vuelo");
        }
    }
}
