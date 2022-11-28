package com.api.semanatec.filter.professor;

import com.api.semanatec.model.entities.Professor;
import com.api.semanatec.model.entities.Usuario;

public class ProfessorMapper {

    public static ProfessorResponseDTO fromEntity(Professor obj) {
        return new ProfessorResponseDTO(obj.getId(), obj.getNome());
    }

    public static Professor fromDTO(ProfessorRequestDTO dto){
        Usuario usuario = new Usuario(null, dto.getUsuario(), dto.getPassword(), null);
        return new Professor(null, dto.getNome(), usuario);
    }

}
