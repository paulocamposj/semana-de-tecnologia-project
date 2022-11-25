package com.api.semanatec.model.dtos.aluno;

import com.api.semanatec.model.entities.Aluno;

public class AlunoMapper {

    public static AlunoResponseDTO fromEntity(Aluno obj) {

        return new AlunoResponseDTO(obj.getId(), obj.getMatricula(), obj.getNome(), obj.getUsuario().getEmail());

    }

}
