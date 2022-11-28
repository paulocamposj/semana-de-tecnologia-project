package com.api.semanatec.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.semanatec.model.dtos.turma.TurmaRequestDTO;
import com.api.semanatec.model.dtos.turma.TurmaResponseDTO;
import com.api.semanatec.service.TurmaService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/turmas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class TurmaController {

	private final TurmaService turmaService;

	@PostMapping
	public ResponseEntity<TurmaResponseDTO> salvar(@RequestBody TurmaRequestDTO dto) {
		return ResponseEntity.ok(turmaService.salvar(dto));

	}

	@GetMapping
	public ResponseEntity<List<TurmaResponseDTO>> listar(@RequestParam(required = false) String professor) {
		return ResponseEntity.ok(turmaService.listar(professor));
	}

}
