package com.eci.arcn.user.application.service;

import com.eci.arcn.user.application.command.RegistrarUsuarioCommand;
import com.eci.arcn.user.domain.model.Usuario;
import com.eci.arcn.user.domain.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RegistrarUsuarioUseCaseTest {

    private UsuarioRepository repository;
    private RegistrarUsuarioUseCase useCase;

    @BeforeEach
    public void setup() {
        repository = Mockito.mock(UsuarioRepository.class);
        useCase = new RegistrarUsuarioUseCase(repository);
    }

    @Test
    public void registroUsuarioValido_devuelveUsuario() {
        // Arrange
        RegistrarUsuarioCommand command = new RegistrarUsuarioCommand("nuevo@correo.com", "clave12345");
        when(repository.buscarPorEmail("nuevo@correo.com")).thenReturn(Optional.empty());

        // Act
        Usuario resultado = useCase.ejecutar(command);

        // Assert
        assertNotNull(resultado);
        assertEquals("nuevo@correo.com", resultado.getEmail());
        verify(repository).guardar(any(Usuario.class));
    }

    @Test
    public void registroUsuarioExistente_lanzaExcepcion() {
        // Arrange
        RegistrarUsuarioCommand command = new RegistrarUsuarioCommand("ya@existe.com", "clave12345");
        when(repository.buscarPorEmail("ya@existe.com")).thenReturn(Optional.of(mock(Usuario.class)));

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            useCase.ejecutar(command);
        });

        assertEquals("El email ya está registrado", exception.getMessage());
        verify(repository, never()).guardar(any());
    }
}
