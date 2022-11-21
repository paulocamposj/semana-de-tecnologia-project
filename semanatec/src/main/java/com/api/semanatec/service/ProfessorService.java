package com.api.semanatec.service;

import org.springframework.stereotype.Service;

import com.api.semanatec.model.entities.Professor;
import com.api.semanatec.repository.ProfessorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;


    public Professor salvar(Professor professor){
        return professorRepository.save(professor);
    }
    
}
