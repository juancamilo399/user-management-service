package com.eci.arcn.user.domain.model;

import org.junit.jupiter.api.Test;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Test
    public void usuarioValido_seCreaCorrectamente() {
        Usuario usuario = new Usuario("correo@ejemplo.com", "passwordSeguro");

        assertEquals("correo@ejemplo.com", usuario.getEmail());
        assertNotNull(usuario.getUserId());
        assertEquals("passwordSeguro", usuario.getPasswordHash());
        assertTrue(usuario.getDirecciones().isEmpty());
    }

    @Test
    public void emailInvalido_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("correoSinArroba", "clave1234");
        });
    }

    @Test
    public void contrasenaInvalida_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("correo@ejemplo.com", "123");
        });
    }

    @Test
    public void agregarDireccionValida_funcionaCorrectamente() {
        Usuario usuario = new Usuario("correo@ejemplo.com", "claveSegura");
        Direccion direccion = new Direccion("Calle 1", "Bogotá", "110111", "Colombia");

        usuario.agregarDireccion(direccion);

        assertEquals(1, usuario.getDirecciones().size());
        assertEquals("Bogotá", usuario.getDirecciones().get(0).getCiudad());
    }

    @Test
    public void agregarDireccionNula_lanzaExcepcion() {
        Usuario usuario = new Usuario("correo@ejemplo.com", "claveSegura");

        assertThrows(IllegalArgumentException.class, () -> {
            usuario.agregarDireccion(null);
        });
    }
}
