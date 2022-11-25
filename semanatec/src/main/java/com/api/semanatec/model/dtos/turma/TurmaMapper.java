package com.api.semanatec.model.dtos.turma;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.api.semanatec.model.dtos.aluno.AlunoMapper;
import com.api.semanatec.model.dtos.aluno.AlunoResponseDTO;
import com.api.semanatec.model.entities.Aluno;
import com.api.semanatec.model.entities.Professor;
import com.api.semanatec.model.entities.Turma;

public class TurmaMapper {

    public static Turma fromDTO(TurmaRequestDTO dto) {

        List<Aluno> alunos = new ArrayList<>();
        for (Long id : dto.getAlunosId()) {
            Aluno aluno = new Aluno();
            aluno.setId(id);
            alunos.add(aluno);
        }
        
        Professor professor = new Professor();
        professor.setId(dto.getProfessorId());
        Turma turma = new Turma(null, dto.getTurma(), professor, alunos, new ArrayList<>());
        return turma;

    }

    public static TurmaResponseDTO fromEntity(Turma obj) {
        List<AlunoResponseDTO> alunos = obj.getAlunos().stream().map(AlunoMapper::fromEntity)
                .collect(Collectors.toList());
        return new TurmaResponseDTO(obj.getId(), obj.getTurma(), obj.getProfessor().getNome(), alunos);
    }

}
