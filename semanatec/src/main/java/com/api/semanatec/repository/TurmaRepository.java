package com.api.semanatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.semanatec.model.entities.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long>{

    List<Turma> findByProfessorNomeContainingIgnoreCase(String professor);

}
