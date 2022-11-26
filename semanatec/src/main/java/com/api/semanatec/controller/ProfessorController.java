package com.api.semanatec.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.semanatec.model.dtos.professor.ProfessorRequestDTO;
import com.api.semanatec.model.dtos.professor.ProfessorResponseDTO;
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
    public ResponseEntity<ProfessorResponseDTO> salvar(@RequestBody ProfessorRequestDTO professor) {
        return ResponseEntity.ok(professorService.salvar(professor));
    }

    @GetMapping
    public ResponseEntity<List<ProfessorResponseDTO>> lsitar() {
        return ResponseEntity.ok(professorService.listar());
    }
}
