package com.sofka.vuelos.vuelo;

import co.com.sofka.domain.generic.ValueObject;
import com.sofka.vuelos.Sexo;

import java.util.Objects;

public class Personal implements ValueObject<Personal> {

    private final String nombre;
    private final Integer edad;
    private final String puesto;
    private final Sexo sexo;

    public Personal(String nombre, Integer edad, String puesto, Sexo sexo){

        this.nombre = Objects.requireNonNull(nombre);
        this.edad = Objects.requireNonNull(edad);
        this.puesto = Objects.requireNonNull(puesto);
        this.sexo = Objects.requireNonNull(sexo);
        if(nombre.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar en blanco");
        }
        if(edad<18){
            throw new IllegalArgumentException("Un empleado no puede ser menor de 18");
        }
        if(puesto.isBlank()){
            throw new IllegalArgumentException("El puesto no puede estar vaio");
        }
    }

    public String nombre() {
        return nombre;
    }

    public Integer edad() {
        return edad;
    }

    public String puesto() {
        return puesto;
    }

    public Sexo sexo() {
        return sexo;
    }

    @Override
    public Personal value() {
        return this;
    }
}
