package com.eci.arcn.user.application.service;

import com.eci.arcn.user.application.command.RegistrarUsuarioCommand;
import com.eci.arcn.user.domain.model.Usuario;
import com.eci.arcn.user.domain.repository.UsuarioRepository;

public class RegistrarUsuarioUseCase {

    private final UsuarioRepository repository;

    public RegistrarUsuarioUseCase(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario ejecutar(RegistrarUsuarioCommand command) {
        if (repository.buscarPorEmail(command.getEmail()).isPresent()) {
            throw new IllegalArgumentException("El email ya está registrado");
        }

        // Simulamos encriptación (debería ser un servicio externo real)
        String hash = "**" + command.getPassword() + "**";

        Usuario nuevoUsuario = new Usuario(command.getEmail(), hash);
        repository.guardar(nuevoUsuario);
        return nuevoUsuario;
    }
}
