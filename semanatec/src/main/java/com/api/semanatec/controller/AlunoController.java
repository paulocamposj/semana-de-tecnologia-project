package com.api.semanatec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.semanatec.repository.AlunoRepository;

@RestController
@RequestMapping("api/v1/alunos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlunoController {
	
	@Autowired
	AlunoRepository repository;
	
	// @PostMapping
	// @Transactional
	// public void cadastra(@RequestBody @Valid DadosAlunos dados) {
	// 	repository.save(new Aluno(dados));
	// }

	@GetMapping
	public ResponseEntity<String> getTest(){
		return ResponseEntity.ok("Chegou!");
	}
}
