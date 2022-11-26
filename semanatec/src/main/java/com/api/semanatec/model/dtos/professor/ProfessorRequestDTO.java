package com.api.semanatec.model.dtos.professor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProfessorRequestDTO {

    private String nome;
    private String usuario;
    private String password;
    
}
