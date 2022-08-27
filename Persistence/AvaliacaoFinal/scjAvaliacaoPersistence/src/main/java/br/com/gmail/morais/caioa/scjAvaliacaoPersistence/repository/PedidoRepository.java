package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.repository;

import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.entity.PedidoEntity;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
    List<PedidoEntity> findAllByClienteContaining(Long idCliente);
}
