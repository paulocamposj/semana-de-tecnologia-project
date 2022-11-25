package com.api.semanatec.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.api.semanatec.model.dtos.aluno.AlunoMapper;
import com.api.semanatec.model.dtos.aluno.AlunoResponseDTO;
import com.api.semanatec.model.entities.Aluno;
import com.api.semanatec.repository.AlunoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public List<AlunoResponseDTO> findByName(String nome) {
        return alunoRepository.findByNomeContainingIgnoreCase(nome).stream().map(AlunoMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
