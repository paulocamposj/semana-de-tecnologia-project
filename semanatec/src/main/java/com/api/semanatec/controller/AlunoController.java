package com.api.semanatec.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.semanatec.model.Aluno;
import com.api.semanatec.repository.AlunoRepository;
import com.api.semanatec.service.DadosAlunos;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	AlunoRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastra(@RequestBody @Valid DadosAlunos dados) {
		repository.save(new Aluno(dados));
	}
}
