package br.com.alura.forumhub.Api.controller;

import br.com.alura.forumhub.Api.infra.security.dto.DadosAutenticacao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.alura.forumhub.Api.infra.security.TokenService;
import br.com.alura.forumhub.Api.infra.security.dto.DadosTokenJWT;
import br.com.alura.forumhub.Api.domain.usuario.Usuario;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    // Injetando o Gerenciador de Autenticação do Spring
    private final AuthenticationManager manager;
    private final TokenService tokenService;

    //Injecão via construtor
    @Autowired
    public AutenticacaoController(AuthenticationManager manager, TokenService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity efetuarLogin (@RequestBody @Valid DadosAutenticacao dados) {

        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
