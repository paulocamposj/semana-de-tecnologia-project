package com.api.semanatec.model.dtos.disciplina;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaRequestDTO {

    private String nome;
    private Long professorId;

}
