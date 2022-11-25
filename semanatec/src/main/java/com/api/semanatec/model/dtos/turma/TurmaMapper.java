package com.api.semanatec.model.dtos.turma;

import com.api.semanatec.model.entities.Aluno;
import com.api.semanatec.model.entities.Professor;
import com.api.semanatec.model.entities.Turma;

public class TurmaMapper {

    public static Turma fromDTO(TurmaRequestDTO dto) {

        Turma turma = new Turma();
        turma.setTurma(dto.getTurma());
        Professor professor = new Professor();
        professor.setId(dto.getProfessorId());
        turma.setProfessor(professor);

        for (Long id : dto.getAlunosId()) {
            Aluno aluno = new Aluno();
            aluno.setId(id);
            turma.getAlunos().add(aluno);
        }
        return turma;
    }

    public static TurmaResponseDTO fromEntity(Turma obj) {
        return new TurmaResponseDTO(obj.getId(), obj.getTurma(), obj.getProfessor().getNome(), obj.getAlunos());
    }

}
