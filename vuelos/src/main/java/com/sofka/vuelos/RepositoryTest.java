package com.sofka.vuelos;

import com.sofka.vuelos.vuelo.*;

import java.util.ArrayList;
import java.util.List;

public class RepositoryTest {



    public Vuelo getVueloById(VueloId vueloId) {
        //Create Ruta
        Ruta rutaAux = new Ruta("Rionegro", "LA", new String[0]);
        //Create listaPasajeros
        List<Pasajero> pasajeros = new ArrayList<>();
        var pasajeroId = new PasajeroId("458");
        Identificacion identificacion = new Identificacion(1456L, "Bob", 32, new Sexo("M"));
        CuidadosExtra cuidadosAux = new CuidadosExtra(false, false, false, false);
        pasajeros.add(new Pasajero(pasajeroId, identificacion, cuidadosAux));
        //Create Bodega
        var bodegaId = new BodegaId("456");
        List<PiezaMercancia> piezas = new ArrayList<>();
        var etiquetaAux = new Etiqueta(false, "Madrid", "Cali", "OT");
        piezas.add(new PiezaMercancia(5.2F, 6, "xx", etiquetaAux));
        var capacidad = new CapacidadCarga(100, 100, 60, 40);
        var bodega = new Bodega(bodegaId, piezas, capacidad);
        //Create Avion
        AvionId avionId = new AvionId("4659");
        String[] restricciones = new String[]{"Ninguna"};
        Carnet carnet = new Carnet("XX", restricciones);
        Piloto piloto = new Piloto("Jhon", carnet, 42, new Sexo("M"));
        Personal personal = new Personal("Vanessa", 26, "Jefa", new Sexo("F"));
        List<Personal> listaPersonal = new ArrayList<>();
        listaPersonal.add(personal);
        Avion avion = new Avion(avionId, piloto, listaPersonal);
        return new Vuelo(vueloId, rutaAux, pasajeros, bodega, avion);
    }
}
