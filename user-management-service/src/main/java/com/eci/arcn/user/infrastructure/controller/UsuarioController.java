package com.eci.arcn.user.infrastructure.controller;

import com.eci.arcn.user.application.command.RegistrarUsuarioCommand;
import com.eci.arcn.user.application.service.RegistrarUsuarioUseCase;
import com.eci.arcn.user.domain.model.Usuario;
import com.eci.arcn.user.infrastructure.dto.RegistroUsuarioRequest;
import com.eci.arcn.user.infrastructure.dto.UsuarioResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final RegistrarUsuarioUseCase useCase;

    public UsuarioController(RegistrarUsuarioUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/registrar")
    public ResponseEntity<UsuarioResponse> registrar(@RequestBody RegistroUsuarioRequest request) {
        RegistrarUsuarioCommand command = new RegistrarUsuarioCommand(
                request.getEmail(), request.getPassword()
        );

        Usuario usuario = useCase.ejecutar(command);
        return ResponseEntity.ok(new UsuarioResponse(usuario.getUserId(), usuario.getEmail()));
    }
}
