package br.com.alura.forumhub.Api.domain.topico;

import br.com.alura.forumhub.Api.domain.topico.dto.DadosCadastroTopico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TopicoService {

    private final TopicoRepository repository;

    @Autowired
    public TopicoService(TopicoRepository repository) {
        this.repository = repository;
    }

    public Topico criar (DadosCadastroTopico dados) {
        if (repository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem())) {
            throw new IllegalArgumentException("Tópico Duplicado!");
        }
        var topico = new Topico(dados);

        repository.save(topico);

        return topico;
    }
}
