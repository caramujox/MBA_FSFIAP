package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.repository;

import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
    List<ProdutoEntity> findAllByNomeContaining(String name);
}
