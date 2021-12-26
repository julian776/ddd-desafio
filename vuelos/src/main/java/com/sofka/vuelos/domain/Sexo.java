package com.sofka.vuelos.domain;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Sexo implements ValueObject<String> {
    private final String sexo;

    public Sexo(String sexo){
        Objects.requireNonNull(sexo);
        if(sexo != "M" && sexo != "F"){
            throw new IllegalArgumentException("El sexo solo puede ser M o F");
        }
        this.sexo = sexo;
    }

    public String sexo() {
        return sexo;
    }

    @Override
    public String value() {
        return sexo;
    }
}
