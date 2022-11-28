package com.api.semanatec.controller;

import java.util.List;

import com.api.semanatec.model.dtos.aluno.AlunoRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.semanatec.model.dtos.aluno.AlunoResponseDTO;
import com.api.semanatec.service.AlunoService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/alunos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class AlunoController {

	private final AlunoService alunoService;

	@GetMapping
	public ResponseEntity<List<AlunoResponseDTO>> listar(@RequestParam(required = false) String nome) {
		return ResponseEntity.ok(alunoService.listar(nome));
	}

	@PostMapping
	public ResponseEntity<AlunoResponseDTO> cadastrar(@RequestBody AlunoRequestDTO aluno) {
		return ResponseEntity.ok(alunoService.salvar(aluno));
	}

	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id ){
		alunoService.excluir(id);
	}

}
