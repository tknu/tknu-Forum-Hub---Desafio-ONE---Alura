package br.com.alura.forumhub.Api.controller;

import br.com.alura.forumhub.Api.domain.topico.TopicoService;
import br.com.alura.forumhub.Api.domain.topico.dto.DadosCadastroTopico;
import br.com.alura.forumhub.Api.domain.topico.TopicoRepository;
import br.com.alura.forumhub.Api.domain.topico.dto.DadosDetalhamentoTopico;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoService service;

    public TopicoController(TopicoService service) {
        this.service = service;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoTopico> cadastrar (@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder) {

        var topico = service.criar(dados);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
    }

}
