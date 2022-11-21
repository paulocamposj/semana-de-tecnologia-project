package com.api.semanatec.service;

import org.springframework.stereotype.Service;

import com.api.semanatec.model.dtos.disciplina.DisciplinaMapper;
import com.api.semanatec.model.dtos.disciplina.DisciplinaRequestDTO;
import com.api.semanatec.model.dtos.disciplina.DisciplinaResponseDTO;
import com.api.semanatec.repository.DisciplinaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    public DisciplinaResponseDTO salvar(DisciplinaRequestDTO dto) {
        return DisciplinaMapper.fromEntity(disciplinaRepository.save(DisciplinaMapper.fromDTO(dto)));
    }

}
