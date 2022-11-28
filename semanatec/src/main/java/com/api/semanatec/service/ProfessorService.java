package com.api.semanatec.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.semanatec.filter.professor.ProfessorMapper;
import com.api.semanatec.filter.professor.ProfessorRequestDTO;
import com.api.semanatec.filter.professor.ProfessorResponseDTO;
import com.api.semanatec.model.entities.Perfil;
import com.api.semanatec.model.entities.Professor;
import com.api.semanatec.repository.PerfilRepository;
import com.api.semanatec.repository.ProfessorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final PerfilRepository perfilRepository;

    public ProfessorResponseDTO salvar(ProfessorRequestDTO dto) {
        Professor professor = ProfessorMapper.fromDTO(dto);
        Perfil perfil = perfilRepository.findById(2L).get(); 
        professor.getUsuario().setPerfil(perfil);
        professor.getUsuario().setSenha(new BCryptPasswordEncoder().encode(dto.getPassword()));
        professorRepository.save(professor);
        return ProfessorMapper.fromEntity(professor);
    }

    public List<ProfessorResponseDTO> listar() {
        return professorRepository.findAll().stream().map(ProfessorMapper::fromEntity).collect(Collectors.toList());
    }

}
