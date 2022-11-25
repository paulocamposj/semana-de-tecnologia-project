package com.api.semanatec.model.dtos.turma;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TurmaRequestDTO {

    private String turma;

    private Long professorId;

    private List<Long> alunosId = new ArrayList<>();

}
