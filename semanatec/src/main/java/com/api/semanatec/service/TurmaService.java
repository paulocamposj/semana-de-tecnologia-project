package com.api.semanatec.service;

import com.api.semanatec.model.dtos.turma.TurmaDto;
import com.api.semanatec.model.entities.Turma;
import com.api.semanatec.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public TurmaDto salvar(Turma turma) {

        TurmaDto turmaDto = new TurmaDto();
        turmaDto.convert(turma);
        turmaRepository.save(turma);
        return turmaDto;
    }
}
