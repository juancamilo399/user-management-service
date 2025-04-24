package com.eci.arcn.user.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegistrarUsuarioCommand {
    private String email;
    private String password;
}
