package com.api.semanatec.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.api.semanatec.model.dtos.turma.TurmaMapper;
import com.api.semanatec.model.dtos.turma.TurmaRequestDTO;
import com.api.semanatec.model.dtos.turma.TurmaResponseDTO;
import com.api.semanatec.model.entities.Aluno;
import com.api.semanatec.model.entities.Professor;
import com.api.semanatec.model.entities.Turma;
import com.api.semanatec.repository.AlunoRepository;
import com.api.semanatec.repository.ProfessorRepository;
import com.api.semanatec.repository.TurmaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TurmaService {

	private final TurmaRepository turmaRepository;
	private final AlunoRepository alunoRepository;
	private final ProfessorRepository professorRepository;

	public TurmaResponseDTO salvar(TurmaRequestDTO dto) {
		Turma turma = new Turma();
		turma.setTurma(dto.getTurma());
		Professor professor = professorRepository.findById(dto.getProfessorId()).get();
		turma.setProfessor(professor);
		for (Long id : dto.getAlunosId()) {
			Aluno a = alunoRepository.findById(id).get();
			turma.getAlunos().add(a);
		}

		turmaRepository.save(turma);
		return TurmaMapper.fromEntity(turma);

	}

	public List<TurmaResponseDTO> listar() {
		return turmaRepository.findAll().stream().map(TurmaMapper::fromEntity).collect(Collectors.toList());
	}
}
