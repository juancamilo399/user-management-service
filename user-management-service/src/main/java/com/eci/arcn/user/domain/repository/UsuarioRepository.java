package com.eci.arcn.user.domain.repository;

import com.eci.arcn.user.domain.model.Usuario;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository {
    void guardar(Usuario usuario);
    Optional<Usuario> buscarPorEmail(String email);
    Optional<Usuario> buscarPorId(UUID userId);
}
