package com.eci.arcn.user.infrastructure.persistence;

import com.eci.arcn.user.domain.model.Usuario;
import com.eci.arcn.user.domain.repository.UsuarioRepository;

import java.util.*;

public class InMemoryUsuarioRepository implements UsuarioRepository {

    private final Map<UUID, Usuario> usuariosPorId = new HashMap<>();
    private final Map<String, Usuario> usuariosPorEmail = new HashMap<>();

    @Override
    public void guardar(Usuario usuario) {
        usuariosPorId.put(usuario.getUserId(), usuario);
        usuariosPorEmail.put(usuario.getEmail(), usuario);
    }

    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        return Optional.ofNullable(usuariosPorEmail.get(email));
    }

    @Override
    public Optional<Usuario> buscarPorId(UUID userId) {
        return Optional.ofNullable(usuariosPorId.get(userId));
    }
}
