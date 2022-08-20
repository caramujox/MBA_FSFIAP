package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.service.interfaces;

import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto.CreateUpdateProdutoDTO;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto.ProdutoDTO;

import java.util.List;

public interface ProdutoService {
    ProdutoDTO create(CreateUpdateProdutoDTO createUpdateProdutoDTO);

    ProdutoDTO findById(Long id);
    List<ProdutoDTO> listAll(String name);
    ProdutoDTO updateClienteDTO(Long id, CreateUpdateProdutoDTO createUpdateProdutoDTO);
    void delete (Long id);
}

