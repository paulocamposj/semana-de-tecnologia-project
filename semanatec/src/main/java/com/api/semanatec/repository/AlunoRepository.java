package com.api.semanatec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.semanatec.model.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
}
