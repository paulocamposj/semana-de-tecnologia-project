package com.api.semanatec.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.api.semanatec.model.entities.Usuario;
import com.api.semanatec.service.AuthService;
import com.api.semanatec.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FiltroAutenticacao extends OncePerRequestFilter {

    private final AuthService authService;
    private final UsuarioService usuarioService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        String token = null;
        if (header != null && header.startsWith("Bearer ")) {
            token = header.substring(7, header.length());
        }

        if (authService.verificaToken(token)) {
            Long idUsuario = authService.retornarIdUsuario(token);
            Usuario usuario = usuarioService.findById(idUsuario);
            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities()));
        }

        filterChain.doFilter(request, response);

    }

}
