package br.com.alura.forumhub.Api.domain.topico.dto;

import br.com.alura.forumhub.Api.domain.topico.StatusTopico;
import br.com.alura.forumhub.Api.domain.topico.Topico;

import java.time.LocalDateTime;

public record DadosListagemTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        StatusTopico status,
        String autor,
        String curso
) {
    public DadosListagemTopico (Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}
