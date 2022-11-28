package com.api.semanatec.model.dtos.aluno;

import com.api.semanatec.model.entities.Aluno;
import com.api.semanatec.model.entities.Usuario;

public class AlunoMapper {

    public static AlunoResponseDTO fromEntity(Aluno obj) {

        return new AlunoResponseDTO(obj.getId(), obj.getMatricula(), obj.getNome(), obj.getUsuario().getEmail());

    }

    public static Aluno fromDTO(AlunoRequestDTO dto){
        Usuario usuario = new Usuario(null, dto.getUsuario(), dto.getPassword(), null);
        return new Aluno(null, dto.getMatricula() ,dto.getNome(), usuario, null);
    }

}
