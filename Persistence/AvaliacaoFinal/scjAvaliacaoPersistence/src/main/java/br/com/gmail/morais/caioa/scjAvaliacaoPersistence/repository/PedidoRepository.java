package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.repository;

import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
}
