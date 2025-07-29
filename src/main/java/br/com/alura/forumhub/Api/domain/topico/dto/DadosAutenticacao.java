package br.com.alura.forumhub.Api.domain.topico.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosAutenticacao (

        @NotBlank
        String email,

        @NotBlank
        String senha) {
}
