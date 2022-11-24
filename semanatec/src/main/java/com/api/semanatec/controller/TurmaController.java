package com.api.semanatec.controller;

import com.api.semanatec.model.dtos.turma.TurmaDto;
import com.api.semanatec.model.entities.Turma;
import com.api.semanatec.service.TurmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/turma")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @PostMapping
    public ResponseEntity<TurmaDto> salvar(@RequestBody Turma turma) {
        return ResponseEntity.ok(turmaService.salvar(turma));
    }
}
