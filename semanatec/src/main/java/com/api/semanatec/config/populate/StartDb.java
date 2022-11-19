package com.api.semanatec.config.populate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.api.semanatec.model.entities.Perfil;
import com.api.semanatec.model.entities.Usuario;
import com.api.semanatec.repository.PerfilRepository;
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

    @Override
    public void run(String... args) throws Exception {

        Perfil p1 = new Perfil(null, "ADMIN");
        Perfil p2 = new Perfil(null, "PROFESSOR");
        List<Perfil> listaPerfis = perfilRepository.findAll();

        if (listaPerfis.isEmpty()) {
            perfilRepository.saveAll(List.of(p1, p2));

            Usuario u1 = new Usuario(null, "admin@ficr.com", new BCryptPasswordEncoder().encode("123456"), p1);
            Usuario u2 = new Usuario(null, "diogenes.matias@ficr.com", new BCryptPasswordEncoder().encode("123456"), p2);
            
            usuarioRepository.saveAll(List.of(u1,u2));
        }
    }

}
