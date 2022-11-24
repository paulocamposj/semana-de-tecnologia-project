package com.api.semanatec.model.dtos.turma;

import com.api.semanatec.model.entities.Aluno;
import com.api.semanatec.model.entities.Professor;
import com.api.semanatec.model.entities.Turma;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
public class TurmaDto {

    private String curso;
    private List<Professor> professores;
    private List<Aluno> alunos;

    public TurmaDto convert(Turma turma) {
        BeanUtils.copyProperties(turma, this, "id", "periodo", "aulas");
        return this;
    }



}
