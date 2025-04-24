package com.eci.arcn.user;

import com.eci.arcn.user.application.service.RegistrarUsuarioUseCase;
import com.eci.arcn.user.domain.repository.UsuarioRepository;
import com.eci.arcn.user.infrastructure.controller.UsuarioController;
import com.eci.arcn.user.infrastructure.persistence.InMemoryUsuarioRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserManagementApplication.class, args);
    }

    @Bean
    public UsuarioRepository usuarioRepository() {
        return new InMemoryUsuarioRepository();
    }

    @Bean
    public RegistrarUsuarioUseCase registrarUsuarioUseCase(UsuarioRepository repository) {
        return new RegistrarUsuarioUseCase(repository);
    }

    @Bean
    public UsuarioController usuarioController(RegistrarUsuarioUseCase useCase) {
        return new UsuarioController(useCase);
    }
}
