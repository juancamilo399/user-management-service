package com.eci.arcn.user.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class UsuarioResponse {
    private UUID id;
    private String email;
}
