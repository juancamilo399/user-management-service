package com.eci.arcn.user.domain.model;

import lombok.Value;

@Value
public class Direccion {
    String calle;
    String ciudad;
    String codigoPostal;
    String pais;

    public Direccion(String calle, String ciudad, String codigoPostal, String pais) {
        if (calle == null || ciudad == null || codigoPostal == null || pais == null) {
            throw new IllegalArgumentException("Todos los campos de la dirección son obligatorios.");
        }
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
    }
}
