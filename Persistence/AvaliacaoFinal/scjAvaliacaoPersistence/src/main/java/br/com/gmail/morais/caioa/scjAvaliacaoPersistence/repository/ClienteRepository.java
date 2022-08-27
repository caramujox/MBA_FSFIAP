package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.repository;

import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    List<ClienteEntity> findAllByNomeContaining(String nome);
}
