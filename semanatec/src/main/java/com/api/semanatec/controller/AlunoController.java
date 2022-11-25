package com.api.semanatec.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.semanatec.model.dtos.aluno.AlunoResponseDTO;
import com.api.semanatec.service.AlunoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/alunos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class AlunoController {

	private final AlunoService alunoService;

	@GetMapping("/nome")
	public ResponseEntity<List<AlunoResponseDTO>> findByNome(@RequestParam String nome) {
		return ResponseEntity.ok(alunoService.findByName(nome));
	}

	@GetMapping("/test")
	public ResponseEntity<String> getTest() {
		return ResponseEntity.ok("Chegou!");
	}
}
