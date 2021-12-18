package br.com.mauricio.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mauricio.cadastro.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
