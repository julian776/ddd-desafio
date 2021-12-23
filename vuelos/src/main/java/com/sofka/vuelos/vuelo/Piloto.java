package com.sofka.vuelos.vuelo;

import co.com.sofka.domain.generic.ValueObject;
import com.sofka.vuelos.Sexo;

import java.util.Objects;

public class Piloto implements ValueObject<Piloto> {

    private final String nombre;
    private final Carnet carnet;
    private final Integer edad;
    private final Sexo sexo;

    public Piloto(String nombre, Carnet carnet, Integer edad, Sexo sexo){

        this.nombre = Objects.requireNonNull(nombre);
        this.carnet = Objects.requireNonNull(carnet);
        this.edad = Objects.requireNonNull(edad);
        this.sexo = Objects.requireNonNull(sexo);

        if(nombre.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar en blanco");
        }
        if(edad < 21){
            throw new IllegalArgumentException("Ningun piloto puede ser menor de 21");
        }
    }

    public String nombre() {
        return nombre;
    }

    public Carnet carnet() {
        return carnet;
    }

    public Integer edad() {
        return edad;
    }

    public Sexo sexo() {
        return sexo;
    }

    @Override
    public Piloto value() {
        return new Piloto(nombre, carnet, edad, sexo);
    }
}
