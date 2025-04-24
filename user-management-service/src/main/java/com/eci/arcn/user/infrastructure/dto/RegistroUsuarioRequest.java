package com.eci.arcn.user.infrastructure.dto;

import lombok.Data;

@Data
public class RegistroUsuarioRequest {
    private String email;
    private String password;
}
