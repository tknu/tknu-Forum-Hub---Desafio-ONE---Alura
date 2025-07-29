package br.com.alura.forumhub.Api.infra.security.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosAutenticacao(@NotBlank String login, @NotBlank String senha) {
}
