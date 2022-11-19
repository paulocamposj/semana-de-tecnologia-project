package com.api.semanatec.model.dtos.disciplina;

import com.api.semanatec.model.entities.Disciplina;
import com.api.semanatec.model.entities.Professor;

import lombok.Data;

public class DisciplinaMapper {


    public static Disciplina fromDTO(DisciplinaRequestDTO dto){
        Professor professor = new Professor();
        professor.setId(dto.getProfessorId());
        return new Disciplina(null, dto.getNome(), professor);
    }

    public static DisciplinaResponseDTO fromEntity(Disciplina obj){
        return new DisciplinaResponseDTO(obj.getId(), obj.getNome());
    }
    
}
