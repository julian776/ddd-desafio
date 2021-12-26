package com.sofka.vuelos.vuelo;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CuidadosExtra implements ValueObject<CuidadosExtra> {

    private final Boolean oxigeno;
    private final Boolean embarazo;
    private final Boolean mareo;
    private final Boolean bebe;

    public CuidadosExtra(Boolean oxigeno, Boolean embarazo, Boolean mareo, Boolean bebe){

        this.oxigeno = Objects.requireNonNull(oxigeno);
        this.embarazo = Objects.requireNonNull(embarazo);
        this.mareo = Objects.requireNonNull(mareo);
        this.bebe = Objects.requireNonNull(bebe);
    }

    public Boolean oxigeno() {
        return oxigeno;
    }

    public Boolean embarazo() {
        return embarazo;
    }

    public Boolean mareo() {
        return mareo;
    }

    public Boolean bebe() {
        return bebe;
    }

    @Override
    public CuidadosExtra value() {
        return this;
    }

    public CuidadosExtra actualizar(Boolean oxigeno, Boolean embarazo, Boolean mareo, Boolean bebe) {
        return new CuidadosExtra(oxigeno, embarazo, mareo, bebe);
    }
}
