package com.eci.arcn.user.domain.model;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Usuario {
    private final UUID userId;
    private final String email;
    private final String passwordHash;
    private final List<Direccion> direcciones;

    public Usuario(String email, String passwordHash) {
        if (!email.contains("@")) throw new IllegalArgumentException("Email inválido");
        if (passwordHash == null || passwordHash.length() < 8)
            throw new IllegalArgumentException("Contraseña insegura");

        this.userId = UUID.randomUUID();
        this.email = email;
        this.passwordHash = passwordHash;
        this.direcciones = new ArrayList<>();
    }

    public void agregarDireccion(Direccion direccion) {
        if (direccion == null) throw new IllegalArgumentException("Dirección inválida");
        this.direcciones.add(direccion);
    }
}
