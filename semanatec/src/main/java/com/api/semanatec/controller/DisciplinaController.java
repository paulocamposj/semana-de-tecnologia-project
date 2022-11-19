package com.api.semanatec.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.semanatec.model.dtos.disciplina.DisciplinaRequestDTO;
import com.api.semanatec.model.dtos.disciplina.DisciplinaResponseDTO;
import com.api.semanatec.service.DisciplinaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/disciplinas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    @PostMapping
    public ResponseEntity<DisciplinaResponseDTO> salvar(@RequestBody DisciplinaRequestDTO dto) {
        return ResponseEntity.ok(disciplinaService.salvar(dto));

    }

}
