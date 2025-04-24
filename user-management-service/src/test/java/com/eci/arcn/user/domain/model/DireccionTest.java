package com.eci.arcn.user.domain.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DireccionTest {

    @Test
    public void direccionValida_creaObjetoCorrectamente() {
        Direccion direccion = new Direccion("Calle 123", "Bogotá", "110111", "Colombia");

        assertEquals("Calle 123", direccion.getCalle());
        assertEquals("Bogotá", direccion.getCiudad());
        assertEquals("110111", direccion.getCodigoPostal());
        assertEquals("Colombia", direccion.getPais());
    }

    @Test
    public void direccionInvalida_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Direccion(null, "Bogotá", "110111", "Colombia");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Direccion("Calle 123", null, "110111", "Colombia");
        });
    }
}
