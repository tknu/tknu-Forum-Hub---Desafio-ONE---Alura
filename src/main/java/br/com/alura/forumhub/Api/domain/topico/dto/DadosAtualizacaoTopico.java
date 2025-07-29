package br.com.alura.forumhub.Api.domain.topico.dto;

import br.com.alura.forumhub.Api.domain.topico.StatusTopico;

public record DadosAtualizacaoTopico(
        String titulo,
        String mensagem,
        StatusTopico status
) {
}
