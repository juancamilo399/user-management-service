package com.eci.arcn.user.infrastructure.persistence;

import com.eci.arcn.user.domain.model.Usuario;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class InMemoryUsuarioRepositoryTest {

    @Test
    void guardaYRecuperaUsuarioPorEmail() {
        InMemoryUsuarioRepository repo = new InMemoryUsuarioRepository();
        Usuario usuario = new Usuario("test@correo.com", "claveSegura123");
        repo.guardar(usuario);

        Optional<Usuario> recuperado = repo.buscarPorEmail("test@correo.com");

        assertTrue(recuperado.isPresent());
        assertEquals("test@correo.com", recuperado.get().getEmail());
    }
}
