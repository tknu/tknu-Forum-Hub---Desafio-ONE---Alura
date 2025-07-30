package br.com.alura.forumhub.Api.domain.topico;

import br.com.alura.forumhub.Api.domain.topico.dto.DadosAtualizacaoTopico;
import br.com.alura.forumhub.Api.domain.topico.dto.DadosCadastroTopico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private StatusTopico status;

    private String autor;
    private String curso;

    @Column(columnDefinition = "TINYINT(1)")
    private Boolean ativo;

    // Construtor para criação, onde alguns campos  são definidos automaticamente
    public Topico(DadosCadastroTopico dados) {
        this.ativo = true;
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.autor = dados.autor();
        this.curso = dados.curso();
        this.dataCriacao = LocalDateTime.now();
        this.status = StatusTopico.NAO_RESPONDIDO;
    }

    // Método para Atualização
    public void atualizarInformacoes(DadosAtualizacaoTopico dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }
        if (dados.status() != null) {
            this.status = dados.status();
        }
    }

    // Método para exclusão lógoca
    public void excluir() {
        this.ativo = false;
    }
}
