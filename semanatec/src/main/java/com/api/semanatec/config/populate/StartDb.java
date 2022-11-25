package com.api.semanatec.config.populate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.api.semanatec.model.entities.Aluno;
import com.api.semanatec.model.entities.Perfil;
import com.api.semanatec.model.entities.Professor;
import com.api.semanatec.model.entities.Usuario;
import com.api.semanatec.repository.AlunoRepository;
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
			Usuario u2 = new Usuario(null, "diogenes.matias@p.ficr.edu.br",
					new BCryptPasswordEncoder().encode("123456"), p2);
			Usuario u3 = new Usuario(null, "wagner.silva@p.ficr.edu.br", new BCryptPasswordEncoder().encode("123456"),
					p2);
			Usuario u4 = new Usuario(null, "jose.ofilho@a.ficr.edu.br", new BCryptPasswordEncoder().encode("123456"),
					p3);
			Usuario u5 = new Usuario(null, "paulo.serafim@a.ficr.edu.br", new BCryptPasswordEncoder().encode("123456"),
					p3);
			Usuario u6 = new Usuario(null, "gustavo.vieira@a.ficr.edu.br", new BCryptPasswordEncoder().encode("123456"),
					p3);
			Usuario u7 = new Usuario(null, "andrews.lima@a.ficr.edu.br", new BCryptPasswordEncoder().encode("123456"),
					p3);
			Usuario u8 = new Usuario(null, "barbara.anizio@a.ficr.edu.br", new BCryptPasswordEncoder().encode("123456"),
					p3);
			Usuario u9 = new Usuario(null, "david.leal@a.ficr.edu.br", new BCryptPasswordEncoder().encode("123456"),
					p3);
			usuarioRepository.saveAll(List.of(u1, u2, u3, u4, u5, u6, u7, u8, u9));

			Professor professor1 = new Professor(null, "Diogenes Carvalho Matias", u2);
			Professor professor2 = new Professor(null, "Wagner Johnatan da Silva", u3);
			professorRepository.saveAll(List.of(professor1, professor2));

			Aluno a1 = new Aluno(null, "FR0001", "José Orlando Ferreira do N. Filho", u4, new ArrayList<>());
			Aluno a2 = new Aluno(null, "FR0002", "Paulo Ricardo Serafim Campos", u5, new ArrayList<>());
			Aluno a3 = new Aluno(null, "FR0003", "Gustavo Vieira dos Santos", u6, new ArrayList<>());
			Aluno a4 = new Aluno(null, "FR0004", "Andrews Jose Clemente De Lima", u7, new ArrayList<>());
			Aluno a5 = new Aluno(null, "FR0005", "Barbara Bianca Anizio Vicente Da Silva", u8, new ArrayList<>());
			Aluno a6 = new Aluno(null, "FR0006", "David Lucas Campos Leal", u9, new ArrayList<>());
			alunoRepository.saveAll(List.of(a1, a2, a3, a4, a5, a6));

			// Turma t1 = new Turma(null, "ADS/SI 4 Noite", professor2, List.of(a1, a2, a3),
			// new ArrayList<>());
			// turmaRepository.save(t1);

		}
	}

}
