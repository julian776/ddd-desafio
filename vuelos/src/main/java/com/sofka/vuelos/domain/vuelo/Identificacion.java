package com.sofka.vuelos.domain.vuelo;

import co.com.sofka.domain.generic.ValueObject;
import com.sofka.vuelos.domain.Sexo;

import java.util.Objects;

public class Identificacion implements ValueObject<Identificacion> {

    private final Long numeroIdentificacion;
    private final String nombre;
    private final Integer edad;
    private final Sexo sexo;

    public Identificacion(Long numeroIdentificacion, String nombre, Integer edad, Sexo sexo){

        this.numeroIdentificacion = Objects.requireNonNull(numeroIdentificacion);
        this.nombre = Objects.requireNonNull(nombre);
        this.edad = Objects.requireNonNull(edad);
        this.sexo = Objects.requireNonNull(sexo);

        if(numeroIdentificacion<0){
            throw new IllegalArgumentException("No se puede tener un numero de identificacion negativo");
        }
        if(nombre.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        if(edad<0){
            throw new IllegalArgumentException("No puede existir un pasajero con edad negativa");
        }
    }

    public Identificacion actualizarSexo(Sexo sexo){
        Objects.requireNonNull(sexo);
        return new Identificacion(this.numeroIdentificacion, this.nombre, this.edad, sexo);
    }

    public Identificacion actualizarEdad(Integer edad){
        Objects.requireNonNull(edad);
        return new Identificacion(this.numeroIdentificacion, this.nombre, edad, this.sexo);
    }

    public Long numeroIdentificacion() {
        return numeroIdentificacion;
    }

    public String nombre() {
        return nombre;
    }

    public Integer edad() {
        return edad;
    }

    public Sexo sexo() {
        return sexo;
    }

    @Override
    public Identificacion value() {
        return this;
    }
}
