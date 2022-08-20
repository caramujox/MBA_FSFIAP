package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.service;

import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto.CreateUpdateProdutoDTO;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto.ProdutoDTO;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.entity.ProdutoEntity;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.repository.ProdutoRepository;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.service.interfaces.ProdutoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private ProdutoRepository repository;
    private ObjectMapper objectMapper;
    @Override
    public ProdutoDTO create(CreateUpdateProdutoDTO createUpdateProdutoDTO) {
        ProdutoEntity savedEntity = repository.save(objectMapper.convertValue(createUpdateProdutoDTO, ProdutoEntity.class));
        return new ProdutoDTO(savedEntity);
    }

    @Override
    public ProdutoDTO findById(Long id) {
        return null;
    }

    @Override
    public List<ProdutoDTO> listAll(String name) {
        return null;
    }

    @Override
    public ProdutoDTO updateClienteDTO(Long id, CreateUpdateProdutoDTO createUpdateClienteDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
