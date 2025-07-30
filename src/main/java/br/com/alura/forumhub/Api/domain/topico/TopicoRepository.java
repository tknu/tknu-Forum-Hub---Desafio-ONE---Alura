package br.com.alura.forumhub.Api.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    // Método para checar se já existe um tópico com o mesmo título e mensagem
    boolean existsByTituloAndMensagem(String titulo, String mensagem);

    Page<Topico> findAllByAtivoTrue (Pageable paginacao);
}
