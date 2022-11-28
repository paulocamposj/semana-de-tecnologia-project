package com.api.semanatec.model.dtos.aluno;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlunoRequestDTO {

    private String nome;
    private String matricula;
    private String usuario;
    private String password;

}
