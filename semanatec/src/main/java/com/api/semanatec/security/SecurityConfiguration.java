package com.api.semanatec.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.api.semanatec.filter.FiltroAutenticacao;
import com.api.semanatec.service.AuthService;
import com.api.semanatec.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration{

    @Autowired
    private final UsuarioService usuarioService;

    @Autowired
    private final AuthService authService;

	private static final String[] AUTH_WHITELIST = {
        // -- Swagger UI v2
        "/v2/api-docs", "/swagger-resources", "/swagger-resources/**", "/configuration/ui"
        , "/configuration/security", "/swagger-ui.html", "/webjars/**"
        // -- Swagger UI v3 (OpenAPI)
        , "/v3/api-docs/**", "/swagger-ui/**", "/api-docs/**"
        // other public endpoints of your API may be appended to this array
};
	
    @Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	WebSecurityCustomizer webSecurityCustomizer() {
		return web -> web.ignoring().antMatchers();
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http, AuthService authService,
			UsuarioService usuarioService) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/auth").permitAll().and().authorizeRequests()
				.antMatchers(HttpMethod.GET, "/api/v1/alunos").permitAll()
				.antMatchers(AUTH_WHITELIST).permitAll()
				.anyRequest().authenticated().and().csrf()
				.disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .addFilterBefore(new FiltroAutenticacao(authService, usuarioService), UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
    
}
