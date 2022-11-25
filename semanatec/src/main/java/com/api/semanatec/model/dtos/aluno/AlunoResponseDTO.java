package com.api.semanatec.model.dtos.aluno;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AlunoResponseDTO {

    private Long id;
    private String matricula;
    private String nome;
    private String usuario;
}
