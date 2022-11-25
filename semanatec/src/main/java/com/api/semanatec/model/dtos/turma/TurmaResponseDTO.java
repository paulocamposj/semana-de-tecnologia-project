package com.api.semanatec.model.dtos.turma;

import java.util.ArrayList;
import java.util.List;

import com.api.semanatec.model.entities.Aluno;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TurmaResponseDTO {

    private Long id;

    private String turma;

    private String professor;
   
    private List<Aluno> alunos = new ArrayList<>();

}
