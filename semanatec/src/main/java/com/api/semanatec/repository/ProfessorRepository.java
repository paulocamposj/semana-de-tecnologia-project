package com.api.semanatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.semanatec.model.entities.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{

    List<Professor> findByNomeContainingIgnoreCase(String nome);
    
}
