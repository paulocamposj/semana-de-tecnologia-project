package com.api.semanatec.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.semanatec.model.dtos.Auth.AuthRequestDTO;
import com.api.semanatec.model.dtos.token.TokenDTO;
import com.api.semanatec.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;

    @PostMapping
    public ResponseEntity<TokenDTO> authenticate(@RequestBody AuthRequestDTO dto) {
        try {
            return ResponseEntity.ok(authService.autenticar(dto));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }

}
