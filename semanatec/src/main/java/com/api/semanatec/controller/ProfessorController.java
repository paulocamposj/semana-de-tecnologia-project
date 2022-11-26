package com.api.semanatec.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.semanatec.model.entities.Professor;
import com.api.semanatec.service.ProfessorService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/professores")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class ProfessorController {

    private final ProfessorService professorService;

    @PostMapping
    public ResponseEntity<Professor> salvar(@RequestBody Professor professor) {
        return ResponseEntity.ok(professorService.salvar(professor));
    }
}
