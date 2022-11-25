package com.api.semanatec.model.dtos.turma;

import java.util.ArrayList;
import java.util.List;

import com.api.semanatec.model.dtos.aluno.AlunoResponseDTO;

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
   
    private List<AlunoResponseDTO> alunos = new ArrayList<>();

}
