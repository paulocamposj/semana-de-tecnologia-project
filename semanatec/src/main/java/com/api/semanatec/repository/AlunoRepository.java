package com.api.semanatec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.semanatec.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
}
