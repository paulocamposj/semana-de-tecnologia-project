package com.api.semanatec.config.populate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.api.semanatec.model.entities.Disciplina;
import com.api.semanatec.model.entities.Perfil;
import com.api.semanatec.model.entities.Professor;
import com.api.semanatec.model.entities.Usuario;
import com.api.semanatec.repository.DisciplinaRepository;
import com.api.semanatec.repository.PerfilRepository;
import com.api.semanatec.repository.ProfessorRepository;
import com.api.semanatec.repository.UsuarioRepository;
import com.api.semanatec.service.UsuarioService;

@Component
public class StartDb implements CommandLineRunner {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilRepository perfilRepository;
    
    @Autowired
    private ProfessorRepository professorRepository;
    
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Override
    public void run(String... args) throws Exception {

        Perfil p1 = new Perfil(null, "ADMIN");
        Perfil p2 = new Perfil(null, "PROFESSOR");
        Perfil p3 = new Perfil(null, "ALUNO");
        
        List<Perfil> listaPerfis = perfilRepository.findAll();

        if (listaPerfis.isEmpty()) {
            perfilRepository.saveAll(List.of(p1, p2));

            Usuario u1 = new Usuario(null, "admin@ficr.edu.br", new BCryptPasswordEncoder().encode("123456"), p1);
            Usuario u2 = new Usuario(null, "diogenes.matias@p.ficr.edu.br", new BCryptPasswordEncoder().encode("123456"), p2);
            Usuario u3 = new Usuario(null, "wagner.silva@p.ficr.edu.br", new BCryptPasswordEncoder().encode("123456"), p2);
            usuarioRepository.saveAll(List.of(u1,u2, u3));
            
            Professor professor1 = new Professor(null, "Diogenes Carvalho Matias", "FR1234", u2, new ArrayList<>());
            Professor professor2 = new Professor(null, "Wagner Johnatan da Silva", "FR4567", u2, new ArrayList<>());
            professorRepository.saveAll(List.of(professor1, professor2));
            
            Disciplina d1 = new Disciplina(null, "Projeto Extensão 4", professor1);
            Disciplina d2 = new Disciplina(null, "Programação Web", professor2);
            Disciplina d3 = new Disciplina(null, "Programação Mobile", professor2);
            disciplinaRepository.saveAll(List.of(d1,d2,d3));
            
        }
    }

}
