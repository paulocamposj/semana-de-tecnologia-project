package com.api.semanatec.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.api.semanatec.model.dtos.Auth.AuthRequestDTO;
import com.api.semanatec.model.dtos.token.TokenDTO;
import com.api.semanatec.model.entities.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private AuthenticationManager authManager;

    @Value("${ficr.jwt.expiration}")
    private String expiration;

    @Value("${ficr.jwt.secret}")
    private String secret;

    @Value("${ficr.jwt.issuer}")
    private String issuer;

    public TokenDTO autenticar(AuthRequestDTO authRequestDTO) throws AuthenticationException {

        Authentication authenticate = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequestDTO.getEmail(), authRequestDTO.getSenha()));
        String token = gerarToken(authenticate);
        return new TokenDTO(token);
    }

    private Algorithm criarAlgorithm() {
        return Algorithm.HMAC256(secret);
    }

    private String gerarToken(Authentication authenticate) {
        Usuario principal = (Usuario) authenticate.getPrincipal();
        Date hoje = new Date();
        Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));

        return JWT.create().withIssuer(issuer).withExpiresAt(dataExpiracao).withSubject(principal.getId().toString())
        		.withClaim("usuario", principal.getEmail())
                .withClaim("role", principal.getPerfil().getTipo())
                .sign(this.criarAlgorithm());
    }

    public boolean verificaToken(String token) {

        try {
            if (token == null)
                return false;
            JWT.require(this.criarAlgorithm()).withIssuer(issuer).build().verify(token);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }

    }

    public long retornarIdUsuario(String token) {
        String subject = JWT.require(this.criarAlgorithm()).withIssuer(issuer).build().verify(token).getSubject();
        return Long.parseLong(subject);
    }

}
