package com.api.semanatec.config.populate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.api.semanatec.model.entities.Aluno;
import com.api.semanatec.model.entities.Disciplina;
import com.api.semanatec.model.entities.Perfil;
import com.api.semanatec.model.entities.Professor;
import com.api.semanatec.model.entities.Turma;
import com.api.semanatec.model.entities.Usuario;
import com.api.semanatec.repository.AlunoRepository;
import com.api.semanatec.repository.DisciplinaRepository;
import com.api.semanatec.repository.PerfilRepository;
import com.api.semanatec.repository.ProfessorRepository;
import com.api.semanatec.repository.TurmaRepository;
import com.api.semanatec.repository.UsuarioRepository;

@Component
public class StartDb implements CommandLineRunner {
	
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilRepository perfilRepository;
    
    @Autowired
    private ProfessorRepository professorRepository;
    
    @Autowired
    private DisciplinaRepository disciplinaRepository;
    
    @Autowired
    private TurmaRepository turmaRepository;
    
    @Autowired
    private AlunoRepository alunoRepository;
    
    @Override
    public void run(String... args) throws Exception {

        Perfil p1 = new Perfil(null, "ADMIN");
        Perfil p2 = new Perfil(null, "PROFESSOR");
        Perfil p3 = new Perfil(null, "ALUNO");
        
        List<Perfil> listaPerfis = perfilRepository.findAll();

        if (listaPerfis.isEmpty()) {
            perfilRepository.saveAll(List.of(p1, p2, p3));

            Usuario u1 = new Usuario(null, "admin@s.ficr.edu.br", new BCryptPasswordEncoder().encode("123456"), p1);
            Usuario u2 = new Usuario(null, "diogenes.matias@p.ficr.edu.br", new BCryptPasswordEncoder().encode("123456"), p2);
            Usuario u3 = new Usuario(null, "wagner.silva@p.ficr.edu.br",new BCryptPasswordEncoder().encode("123456"), p2);
            Usuario u4 = new Usuario(null, "jose.ofilho@a.ficr.edu.br", new BCryptPasswordEncoder().encode("123456"), p3);
            Usuario u5 = new Usuario(null, "paulo.serafim@a.ficr.edu.br", new BCryptPasswordEncoder().encode("123456"), p3);
            Usuario u6 = new Usuario(null, "gustavo.vieira@a.ficr.edu.br", new BCryptPasswordEncoder().encode("123456"), p3);
            usuarioRepository.saveAll(List.of(u1,u2, u3, u4, u5, u6));
            
            Professor professor1 = new Professor(null, "Diogenes Carvalho Matias", "FR1234", u2, new ArrayList<>());
            Professor professor2 = new Professor(null, "Wagner Johnatan da Silva", "FR4567", u2, new ArrayList<>());
            professorRepository.saveAll(List.of(professor1, professor2));
            
            Disciplina d1 = new Disciplina(null, "Projeto Extensão 4", professor1);
            Disciplina d2 = new Disciplina(null, "Programação Web", professor2);
            Disciplina d3 = new Disciplina(null, "Programação Mobile", professor2);
            disciplinaRepository.saveAll(List.of(d1,d2,d3));
            
            Turma t1 = new Turma(null, "ADS/SI", "4Noite", List.of(professor1, professor2), new ArrayList<>(), new ArrayList<>());
            turmaRepository.save(t1);
            
            Aluno a1 = new Aluno(null, "José Orlando Ferreira do N. Filho", u4, new ArrayList<>(), t1);
            Aluno a2 = new Aluno(null, "Paulo Ricardo Serafim Campos", u5, new ArrayList<>(), t1);
            Aluno a3 = new Aluno(null, "Gustavo Vieira dos Santos", u6, new ArrayList<>(), t1);
            alunoRepository.saveAll(List.of(a1, a2, a3));
        }
    }

}
