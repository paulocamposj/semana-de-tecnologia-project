package com.api.semanatec.model.dtos.professor;

import com.api.semanatec.model.entities.Professor;

public class ProfessorMapper {

    public static ProfessorResponseDTO fromEntity(Professor obj) {
        return new ProfessorResponseDTO(obj.getId(), obj.getNome(), obj.getMatricula());
    }

}
