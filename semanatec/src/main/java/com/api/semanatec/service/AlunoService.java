package com.api.semanatec.service;

import com.api.semanatec.model.dtos.aluno.AlunoMapper;
import com.api.semanatec.model.dtos.aluno.AlunoRequestDTO;
import com.api.semanatec.model.dtos.aluno.AlunoResponseDTO;
import com.api.semanatec.model.entities.Aluno;
import com.api.semanatec.model.entities.Perfil;
import com.api.semanatec.repository.AlunoRepository;
import com.api.semanatec.repository.PerfilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    private final PerfilRepository perfilRepository;

    public List<AlunoResponseDTO> listar(String nome) {
        if(nome == null){
            return alunoRepository.findAll().stream().map(AlunoMapper::fromEntity).collect(Collectors.toList());
        }
        return alunoRepository.findByNomeContainingIgnoreCase(nome).stream().map(AlunoMapper::fromEntity)
                .collect(Collectors.toList());
    }

    public AlunoResponseDTO salvar(AlunoRequestDTO dto) {
        Aluno aluno = AlunoMapper.fromDTO(dto);
        Perfil perfil = perfilRepository.findById(3L).get();
        aluno.getUsuario().setPerfil(perfil);
        aluno.getUsuario().setSenha(new BCryptPasswordEncoder().encode(dto.getPassword()));
        alunoRepository.save(aluno);
        return AlunoMapper.fromEntity(aluno);
    }

    public void excluir(Long id) {
        alunoRepository.deleteById(id);
    }
}
