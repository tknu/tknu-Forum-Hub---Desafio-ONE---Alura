package br.com.alura.forumhub.Api.controller;

import br.com.alura.forumhub.Api.domain.topico.TopicoRepository;
import br.com.alura.forumhub.Api.domain.topico.TopicoService;
import br.com.alura.forumhub.Api.domain.topico.dto.DadosAtualizacaoTopico;
import br.com.alura.forumhub.Api.domain.topico.dto.DadosCadastroTopico;
import br.com.alura.forumhub.Api.domain.topico.dto.DadosDetalhamentoTopico;
import br.com.alura.forumhub.Api.domain.topico.dto.DadosListagemTopico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page; // <-- IMPORT CORRIGIDO
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
@Tag(name = "Tópicos", description = "Operações relacionadas a tópicos do fórum")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    private final TopicoService service;
    private final TopicoRepository repository;

    public TopicoController(TopicoRepository repository, TopicoService service) {

        this.repository = repository;
        this.service = service;
    }

    @PostMapping
    @Transactional
    @Operation(summary = "Criar um novo tópico",
            description = "Registra um novo tópico no banco de dados. Requer autenticação.")
    public ResponseEntity<DadosDetalhamentoTopico> cadastrar (@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder) {

        var topico = service.criar(dados);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
    }

    @GetMapping
    @Operation(summary = "Listar todos os tópicos ativos",
            description = "Retorna uma lista paginada de todos os tópicos que não foram logicamente excluídos.")
    public ResponseEntity<Page<DadosListagemTopico>> listar(
            @PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao
    ) {
        var page =
                repository.findAllByAtivoTrue(paginacao)
                        .map(DadosListagemTopico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Detalhar um tópico por ID",
            description = "Retorna os detalhes completos de um tópico específico, buscando pelo seu ID.")
    public ResponseEntity<DadosDetalhamentoTopico> detalhar(@PathVariable Long id) {

        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));

    }

    @PutMapping("/{id}")
    @Transactional
    @Operation(summary = "Atualizar um tópico por ID",
            description = "Atualiza as informações (título e/ou mensagem) de um tópico existente.")
    public ResponseEntity<DadosDetalhamentoTopico> atualizar
            (@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoTopico dados) {

        var topico = repository.getReferenceById(id);
        topico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(summary = "Excluir um tópico por ID (Exclusão Lógica)",
            description = "Marca um tópico como inativo no banco de dados. O registro não é fisicamente removido.")
    public ResponseEntity excluir(@PathVariable Long id) {

        var topico = repository.getReferenceById(id);

        topico.excluir();

        return ResponseEntity.noContent().build();
    }

}
